package org.example.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import org.example.pojo.Headline;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.pojo.vo.PortalVo;

import java.util.Map;

/**
* @author 79928
* @description 针对表【news_headline】的数据库操作Mapper
* @createDate 2023-11-07 10:00:32
* @Entity org.example.pojo.Headline
*/
public interface HeadlineMapper extends BaseMapper<Headline> {
    IPage<Map> selectPageMap(IPage<Map> page, @Param("portalVo") PortalVo portalVo);

    Map queryDetailMap(Integer hid);
}




