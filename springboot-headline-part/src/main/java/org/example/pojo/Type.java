package org.example.pojo;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import lombok.Data;

/**
 * @TableName news_type
 */
// @TableName(value ="news_type")  全局已指定
@Data
public class Type implements Serializable {
    @TableId
    private Integer tid;

    private String tname;
    @Version
    private Integer version;

    private Integer isDeleted;

    private static final long serialVersionUID = 1L;
}