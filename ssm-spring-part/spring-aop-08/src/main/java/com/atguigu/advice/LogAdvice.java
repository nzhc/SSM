package com.atguigu.advice;

/*
* 增强类的增强代码
* */

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
public class LogAdvice {
    @Before("execution(* com.atguigu.impl.*.*(..))")
    public void start(){
        System.out.println("方法开始了");
    }

    @After("execution(* com.atguigu.impl.*.*(..))")
    public void after(){
        System.out.println("方法结束了");
    }

    @AfterThrowing("execution(* com.atguigu.impl.*.*(..))")
    public void error(){
        System.out.println("方法报错了");
    }
}
