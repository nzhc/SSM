package com.atguigu.test;

import com.atguigu.ioc_01.XxxDao;
import com.atguigu.ioc_02.JavaBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIoCTest {

    public void testIoC_01(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-01.xml");
        XxxDao XxxDaoBean = applicationContext.getBean(XxxDao.class);

    }

    @Test
    public void testIoC02(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-02.xml");
        JavaBean javaBean = applicationContext.getBean(JavaBean.class);
        JavaBean javaBean1 = applicationContext.getBean(JavaBean.class);

        applicationContext.close();

    }
}
