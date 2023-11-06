package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 三个功能：本身是配置类、自动加载其他配置类、扫描当前启动类的所在路径的包
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
}