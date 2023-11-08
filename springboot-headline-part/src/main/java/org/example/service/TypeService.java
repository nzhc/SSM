package org.example.service;

import org.example.pojo.Type;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.utils.Result;

/**
* @author 79928
* @description 针对表【news_type】的数据库操作Service
* @createDate 2023-11-07 10:00:32
*/
public interface TypeService extends IService<Type> {

    Result findAllTypes();
}
