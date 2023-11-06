package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.pojo.User;
import org.example.service.UserService;
import org.example.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author 79928
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-11-06 21:24:43
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




