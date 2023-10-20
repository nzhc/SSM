package com.atguigu.advice;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;

@Component
@Aspect
public class MyAdvice {

//    @Before("com.atguigu.pointcut.PointCut.pc()")
    public void before(JoinPoint joinPoint){
        // 获取方法属于类的信息
        String simpleName = joinPoint.getTarget().getClass().getSimpleName();
        // 获取方法名称
        int modifiers = joinPoint.getSignature().getModifiers();
        String s = Modifier.toString(modifiers);
        String name = joinPoint.getSignature().getName();  // 获取方法名
        // 3.获取参数列表
        Object[] args = joinPoint.getArgs();  // 获取目标方法参数

        System.out.println("方法开始前");

    }

//    @AfterReturning(value = "com.atguigu.pointcut.PointCut.pc()", returning = "result")
    public void afterReturing(JoinPoint joinPoint, Object result){
        System.out.println("方法return = " + result);
    }

//    @After("com.atguigu.pointcut.PointCut.pc()")
    public void after(JoinPoint joinPoint){
        System.out.println("方法after");
    }

//    @AfterThrowing(value = "com.atguigu.pointcut.PointCut.pc()", throwing = "throwable")
    public void afterThrowing(JoinPoint joinPoint, Throwable throwable){
        System.out.println("方法异常");
    }


    /**
     * 环绕通知,需要你在通知中,定义目标方法的执行!
     * @param ProceedingJoinPoint  目标方法 (相比JoinPoint除了能获取目标方法信息,多了一个执行方法)
     * @return 目标方法的返回值
     */
    @Around("com.atguigu.pointcut.PointCut.pc()")
    public Object transaction(ProceedingJoinPoint joinPoint){
        //保证目标方法被执行即可
        Object[] args = joinPoint.getArgs();   // 获取目标方法参数
        Object result = null;

        try {
            System.out.println("开启事务");  // Before
            result = joinPoint.proceed(args);  // 主动执行目标方法
            System.out.println("结束事务 result = " + result);  // After

        } catch (Throwable e) {
            System.out.println("事务回滚");  // AfterThrowing
            throw new RuntimeException(e);
        }finally {
            System.out.println("finally result = " + result);
        }
        return result;
    }


}
