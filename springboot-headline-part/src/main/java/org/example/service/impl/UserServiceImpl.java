package org.example.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.pojo.User;
import org.example.service.UserService;
import org.example.mapper.UserMapper;
import org.example.utils.JwtHelper;
import org.example.utils.MD5Util;
import org.example.utils.Result;
import org.example.utils.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 79928
 * @description 针对表【news_user】的数据库操作Service实现
 * @createDate 2023-11-07 10:00:32
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JwtHelper jwtHelper;

    @Override
    public Result login(User user) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getUsername,user.getUsername());
        User loginUser = userMapper.selectOne(lambdaQueryWrapper);
        if(loginUser == null){
            return Result.build(null, ResultCodeEnum.USERNAME_ERROR);
        }
        // 对比密码是否正确
        if(!StringUtils.isEmpty(user.getUserPwd())
                && MD5Util.encrypt(user.getUserPwd()).equals(loginUser.getUserPwd())){
            // 密码不为空且加密后与已保存密码同，说明登录成功
            // 创建token并将其返回
            String token = jwtHelper.createToken(Long.valueOf(loginUser.getUid()));
            Map data = new HashMap();
            data.put("token",token);

            return Result.ok(data);
        }
        // 密码错误
        return Result.build(null, ResultCodeEnum.PASSWORD_ERROR);
    }

    // 根据传入的用户token获取用户详细信息
    @Override
    public Result getUserInfo(String token) {
        // 检查token是否失效、过期
        if(jwtHelper.isExpiration(token)) {
            // token已失效、过期
            return Result.build(null,ResultCodeEnum.NOTLOGIN);
        }
        // 未失效，获取userId和user，并将user的password属性设置为空
        Long uid = jwtHelper.getUserId(token);
        User user = userMapper.selectById(uid);
        user.setUserPwd("");
        
        Map data = new HashMap();
        data.put("loginUsser",user);

        return Result.ok(data);
    }

    @Override
    public Result checkUserName(String username) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getUsername,username);
        User user = userMapper.selectOne(lambdaQueryWrapper);
        if(user != null){
            // 查询到用户名已被占用
            return Result.build(null,ResultCodeEnum.USERNAME_USED);
        }

        return Result.ok(null);
    }

    @Override
    public Result regist(User user) {
        Result checkResult = checkUserName(user.getUsername());
        // 若用户名已被占用，直接返回
        if(checkResult.getCode() == ResultCodeEnum.USERNAME_USED.getCode()){
            return checkResult;
        }
        user.setUserPwd(MD5Util.encrypt(user.getUserPwd()));
        userMapper.insert(user);
        Result result = Result.ok(null);
        return result;
    }
}




