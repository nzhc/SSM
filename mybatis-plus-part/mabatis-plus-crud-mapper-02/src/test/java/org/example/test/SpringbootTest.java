package org.example.test;

import org.apache.ibatis.annotations.Param;
import org.example.mapper.UserMapper;
import org.example.pojo.User;
import org.example.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class SpringbootTest {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    // Mapper层的crud测试
    @Test
    public void test_insert(){
        User user = new User();
        user.setAge(10);
        user.setEmail("hjdasf@qq.com");
        user.setName("zhangsan");
        userMapper.insert(user);
    }
    @Test
    public void delete_insert(){
        List ids = new ArrayList();
        ids.add(6);
        ids.add(7);
        userMapper.deleteBatchIds(ids);
    }
    @Test
    public void update_test(){
        User user = new User();
        user.setId(5L);
        user.setName("liuwu");
        user.setEmail("jjjjj@qq.com");
        userMapper.updateById(user);

    }

    // Service层的crud
    @Test
    public void test_save(){
        List<User> list = new ArrayList<>();
        User user = new User();
        user.setAge(10);
        user.setEmail("hj@qq.com");
        user.setName("lll");
        list.add(user);

        boolean b = userService.saveBatch(list);
        System.out.println("b = "+b);
    }
}
