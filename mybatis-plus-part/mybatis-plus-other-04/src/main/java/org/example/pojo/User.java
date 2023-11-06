package org.example.pojo;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    @TableLogic  // 注解标明是逻辑删除
    private Integer deleted;
    @Version  // 乐观锁的版本号
    private Integer version;
}
