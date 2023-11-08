package org.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.pojo.Type;
import org.example.service.TypeService;
import org.example.mapper.TypeMapper;
import org.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author 79928
* @description 针对表【news_type】的数据库操作Service实现
* @createDate 2023-11-07 10:00:32
*/
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type> implements TypeService{
    @Autowired
    private TypeMapper typeMapper;

    @Override
    public Result findAllTypes() {
        List<Type> types = typeMapper.selectList(null);

        return  Result.ok(types);

    }
}




