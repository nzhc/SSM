package org.example.service;


import org.example.pojo.Headline;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.pojo.vo.PortalVo;
import org.example.utils.Result;

/**
* @author 79928
* @description 针对表【news_headline】的数据库操作Service
* @createDate 2023-11-07 10:00:32
*/
public interface HeadlineService extends IService<Headline> {


    Result findNewsPage(PortalVo portalVo);

    Result showHeadlineDetail(Integer hid);

    Result publish(Headline headline, String token);

    Result updateData(Headline headline);
}
