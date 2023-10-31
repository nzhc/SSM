package org.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {



    @GetMapping("data")
    public String data(){
        // 空指针异常
        String name = null;
        name.toString();
        return "ok";
    }

    @GetMapping("data1")
    public String data1(){
        // 算术异常
        int i = 1 / 0;
        return "ok";
    }
}
