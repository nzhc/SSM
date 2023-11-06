package org.example.test;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.mapper.UserMapper;
import org.example.pojo.User;
import org.example.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class MyBatisPlusTest {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

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

    @Test
    public void testPage(){
        Page<User> page = new Page<>(1,3);
        userMapper.selectPage(page,null);

        // 无需接值，page本身会接收查询结果
        long current = page.getCurrent(); //页码
        long size = page.getSize(); //页容量
        List<User> records = page.getRecords(); //当前页的数据
        long total = page.getTotal(); //总条数
    }

    @Test
    public void test_mypage(){
        Page<User> page = new Page<>(1,3);
        userMapper.queryByAge(page,1);

        long current = page.getCurrent(); //页码
        System.out.println("current = " + current);
        long size = page.getSize(); //页容量
        System.out.println("size = " + size);
        List<User> records = page.getRecords(); //当前页的数据
        System.out.println("records = " + records);
        long total = page.getTotal(); //总条数
        System.out.println("total = " + total);

    }

    @Test
    void test1() {
        User user = userMapper.select1("28", "age");
        System.out.println(user.toString());
    }

    @Test
    void MybatisPlusTableLogicTest(){
//        userMapper.deleteById(1);
//        userMapper.selectList(null);
        User user = new User();
        user.setName("Jone");
        user.setAge(18);
        user.setEmail("test1@baomidou.com");
        userMapper.insert(user);
    }

    @Test
    void leTest(){
//        userMapper.deleteById(1);
//        userMapper.selectList(null);
        User user = new User();
        user.setName("Jone");
        user.setAge(18);
        user.setEmail("test1@baomidou.com");
        userMapper.insert(user);
    }
}
