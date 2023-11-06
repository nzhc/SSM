package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.User;

public interface UserMapper extends BaseMapper<User> {
    //自定义一个根据年龄参数查询，并且分页的方法 age > xx
    IPage<User> queryByAge(IPage<User> page, @Param("age") Integer age);
    @Select("select * from user where ${column} = #{value}")
    User select1(String value, String column);
}
