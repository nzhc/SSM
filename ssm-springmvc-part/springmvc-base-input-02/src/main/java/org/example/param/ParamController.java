package org.example.param;


import org.example.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("param")
public class ParamController {

    // 1.直接接收
    //  /param/data?name=root&age=18
    //  形参列表,填写对应名称的参数即可!  请求参数名 = 形参参数名即可!
    //   1)名称相同  2)可以不传递参数，此时不报错
    @RequestMapping("data")
    @ResponseBody
    public String data(String name,int age){
        System.out.println("name = " + name + ", age = " + age);
        return "name = " + name + ", age = " + age;
    }

    // 2.注解
    @RequestMapping("data1")
    @ResponseBody
    public String data1(@RequestParam(value="name") String aname, @RequestParam(required = false, defaultValue = "1") int age){
        System.out.println("name = " + aname + ", age = " + age);
        return "name = " + aname + ", age = " + age;
    }


    // 一key多值  list
    @RequestMapping("data2")
    @ResponseBody
    public Object data2(@RequestParam List<String> hbs){
        System.out.println("hbs = " + hbs);
        return hbs;
    }

    // 实体类接收
    @RequestMapping(value = "data3", method = RequestMethod.GET)
    @ResponseBody
    public String addUser(User user){
        System.out.println("user = " + user);
        return "sucess";
    }

}
