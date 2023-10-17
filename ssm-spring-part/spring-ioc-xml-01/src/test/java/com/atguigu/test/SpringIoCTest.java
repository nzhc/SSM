package com.atguigu.test;

import com.atguigu.ioc_01.first;
import com.atguigu.ioc_02.JavaBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description: ioc容器创建和读取组件的测试类
 *
 * @Create:2023/10/16 - 17:19
 */
public class SpringIoCTest {
    // 创建ioc容器
    public void createIoC(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-01.xml");

    }

    // 在ioc容器中获取组件bean
    public void getBeanFramIoC(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-01.xml");
        first firstBean = applicationContext.getBean(first.class);  // first类型
        firstBean.dowork();
    }

    @Test
    public void test_02(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-02.xml");

    }

    @Test
    public void test_03(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-02.xml");
        JavaBean javaBean = applicationContext.getBean("javaBean", JavaBean.class);


        applicationContext.close();
    }
}
