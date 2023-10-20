package com.atguigu.test;

import com.atguigu.Calculator;
import com.atguigu.config.JavaConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(value = JavaConfig.class)
public class SpringAopTest {

    // 这里有接口，所以AOP使用JDK方式实现代理，因此类型必须是接口
    @Autowired
    private Calculator calculator;

    @Test
    public void test(){
        int add = calculator.add(1,0);
        System.out.println("add = " + add);
    }
}
