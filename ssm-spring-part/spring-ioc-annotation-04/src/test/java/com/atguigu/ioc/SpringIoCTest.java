package com.atguigu.ioc;

import com.atguigu.controller.StudentController;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIoCTest {

    public void Test(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        StudentController controllerBean = applicationContext.getBean(StudentController.class);
        controllerBean.findAll();
        applicationContext.close();
    }
}
