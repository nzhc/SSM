package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @RequestMapping("springmvc/hello")
    @ResponseBody
    public String hello(){
        System.out.println("hello");

        return "hello SpringMVC";
    }
}
