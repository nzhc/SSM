package org.example.pojo;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @TableName news_headline
 */
// @TableName(value ="news_headline")  全局已指定
@Data
public class Headline implements Serializable {
    // @TableId(value="hid", type=IdType.AUTO)  也不必配，hid与数据库相同，type全局已指定
    @TableId
    private Integer hid;

    private String title;

    private String article;

    private Integer type;

    private Integer publisher;

    private Integer pageViews;

    private Date createTime;

    private Date updateTime;
    @Version
    private Integer version;
    // @TableLogic不必，全局已配
    private Integer isDeleted;

    private static final long serialVersionUID = 1L;
}