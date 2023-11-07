package org.example.controller;


import org.example.pojo.User;
import org.example.service.UserService;
import org.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@CrossOrigin  // 前后端要跨域，需要此注解
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("login")
    public Result<User> login(@RequestBody User user){
        Result result = userService.login(user);

        return result;
    }
}
