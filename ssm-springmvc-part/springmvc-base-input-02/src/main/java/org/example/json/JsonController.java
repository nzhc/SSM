package org.example.json;

import org.example.pojo.Person;
import org.example.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("json")
@ResponseBody
public class JsonController {
    @RequestMapping(value = "/user/detail", method = RequestMethod.POST)
    @ResponseBody
    public User getUser1(@RequestBody User userParam) {
        System.out.println("userParam = " + userParam);
        User user = new User();
        user.setAge(18);
        user.setName("John");
        //返回的对象,会使用jackson的序列化工具,转成json返回给前端!
        return user;
    }
    @GetMapping("/get")
    @ResponseBody
    public User getUser2() {
        System.out.println("userParam = ");
        User user = new User();
        user.setAge(18);
        user.setName("John");
        //返回的对象,会使用jackson的序列化工具,转成json返回给前端!
        return user;
    }
}




