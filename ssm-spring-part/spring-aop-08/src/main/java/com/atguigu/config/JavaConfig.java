package com.atguigu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@ComponentScan("com.atguigu")
@EnableAspectJAutoProxy  // 开启aspectJ的注解
@Configuration
public class JavaConfig {
}
