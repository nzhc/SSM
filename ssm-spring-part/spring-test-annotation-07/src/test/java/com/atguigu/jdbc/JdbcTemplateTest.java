package com.atguigu.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import com.atguigu.config.JavaConfiguration;
import com.atguigu.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * Description:
 *
 * @Create:2023/10/16 - 21:36
 */

@SpringJUnitConfig(value = JavaConfiguration.class)
public class JdbcTemplateTest {

    @Autowired
    private StudentController studentController;

    @Test
    public void testForIOC(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        StudentController studentController = applicationContext.getBean(StudentController.class);
    }

    @Test
    public void testForIoCAnno(){
        studentController.findAll();
    }

}


