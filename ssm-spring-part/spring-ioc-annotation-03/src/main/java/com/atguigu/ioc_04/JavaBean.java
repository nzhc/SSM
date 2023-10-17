package com.atguigu.ioc_04;

import org.springframework.beans.factory.annotation.Value;

public class JavaBean {

    @Value("${jdbc.username:admin}")
    private String username;
    @Value("${jdbc.userpassword:admin}")
    private String userpassword;


    public void doworks(){

    };
}
