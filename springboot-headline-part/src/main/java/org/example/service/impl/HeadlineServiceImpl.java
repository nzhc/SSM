package org.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.mapper.UserMapper;
import org.example.pojo.Headline;
import org.example.pojo.vo.PortalVo;
import org.example.service.HeadlineService;
import org.example.mapper.HeadlineMapper;
import org.example.utils.JwtHelper;
import org.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
* @author 79928
* @description 针对表【news_headline】的数据库操作Service实现
* @createDate 2023-11-07 10:00:32
*/
@Service
public class HeadlineServiceImpl extends ServiceImpl<HeadlineMapper, Headline> implements HeadlineService{
    @Autowired
    private HeadlineMapper headlineMapper;
    @Autowired
    private JwtHelper jwtHelper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public Result findNewsPage(PortalVo portalVo) {
        Page<Map> page = new Page<>(portalVo.getPageNum(),portalVo.getPageSize());
        headlineMapper.selectPageMap(page, portalVo);

        List<Map> records = page.getRecords();
        Map data = new HashMap();
        data.put("pageData", records);
        data.put("pageNum", page.getCurrent());
        data.put("pageSize", page.getSize());
        data.put("totalPage", page.getPages());
        data.put("totalSize", page.getTotal());
        Map pageInfo = new HashMap();
        pageInfo.put("pageInfo", data);

        return Result.ok(pageInfo);
    }

    // 查询headline详细信息，并浏览量++
    @Override
    public Result showHeadlineDetail(Integer hid) {
        // 根据文章id查询详细信息
        Map data = headlineMapper.queryDetailMap(hid);
        Map map = new HashMap();
        map.put("headline",data);
        // 更新文章阅读量
        Headline headline = new Headline();
        headline.setHid((Integer) data.get("hid"));
        headline.setVersion((Integer) data.get("version"));   // 获取当前版本号，乐观锁
        headline.setPageViews((Integer) data.get("pageViews") + 1);
        headlineMapper.updateById(headline);

        return Result.ok(map);
    }

    // 发布headline
    @Override
    public Result publish(Headline headline, String token) {
        // 根据token查询用户id
        int userId = jwtHelper.getUserId(token).intValue();
        // 数据装配
        headline.setPublisher(userId);
        headline.setPageViews(0);
        headline.setCreateTime(new Date());
        headline.setUpdateTime(new Date());

        headlineMapper.insert(headline);

        return Result.ok(null);
    }

    @Override
    public Result updateData(Headline headline) {
        Headline oldHeadline = headlineMapper.selectById(headline.getHid());
        headline.setVersion(oldHeadline.getVersion());  // 乐观锁
        headline.setUpdateTime(new Date());

        headlineMapper.updateById(headline);

        return Result.ok(null);
    }
}




