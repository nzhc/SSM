package com.atguigu.ioc_03;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;


@Controller
public class UserController {

//    @Autowired
//    @Qualifier("userServiceImpl")
//    private UserService userService;

    @Resource(name = "userServiceImpl")
    private UserService userService;

    public void show(){

    }
}
