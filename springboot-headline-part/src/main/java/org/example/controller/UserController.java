package org.example.controller;


import org.example.pojo.User;
import org.example.service.UserService;
import org.example.utils.JwtHelper;
import org.example.utils.Result;
import org.example.utils.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@CrossOrigin  // 前后端要跨域，需要此注解
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtHelper jwtHelper;


    // 登录功能，用户通过json传入用户名密码，登录成功则返回token，失败则返回相应code和message
    @PostMapping("login")
    public Result login(@RequestBody User user){
        Result result = userService.login(user);

        return result;
    }

    // 根据用户通过请求头传入的token获取用户信息，成功返回用户信息，失败则返回相应code和message
    @GetMapping("getUserInfo")
    public Result getUserInfo(@RequestHeader String token){
        Result result = userService.getUserInfo(token);
        return result;
    }
        // 什么时候Result需要指定T类型，如Result<User>
    // 注册用户名检查，检查用户名是否已被占用
    @PostMapping("checkUserName")
    public Result checkUserName(String username){
        Result result = userService.checkUserName(username);
        return result;
    }

    // 用户注册
    @PostMapping("regist")
    public Result regist(@RequestBody User user){
        Result result = userService.regist(user);
        return result;
    }

    // 检查用户token是否有效
    @GetMapping("checkLogin")
    public Result checkLogin(@RequestHeader String token){
        boolean expiration = jwtHelper.isExpiration(token);
        if(expiration){
            // token已过期
            return  Result.build(null, ResultCodeEnum.NOTLOGIN);
        }
        return Result.ok(null);
    }

}
