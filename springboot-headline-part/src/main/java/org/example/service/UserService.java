package org.example.service;

import org.example.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.utils.Result;

/**
* @author 79928
* @description 针对表【news_user】的数据库操作Service
* @createDate 2023-11-07 10:00:32
*/
public interface UserService extends IService<User> {

    // 登录业务
    Result login(User user);

    Result getUserInfo(String token);

    Result checkUserName(String username);

    Result regist(User user);

}
