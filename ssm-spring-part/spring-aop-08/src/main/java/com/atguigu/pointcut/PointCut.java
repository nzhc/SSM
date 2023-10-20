package com.atguigu.pointcut;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class PointCut {

    @Pointcut("execution(* com..impl.*.*(..))")
    public void pc(){}
}
