package com.atguigu.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Import({JavaConfigurationA.class})
@ComponentScan({"com.atguigu.ioc_01", "com.atguigu.ioc_02"})  // 替代XML扫描，可添加多个
@PropertySource(value="classpath:jdbc.properties")            // 替代XML读取外部配置文件
@Configuration
public class JavaConfiguration {
    // 基本类型注入
    @Value("${atguigu.url}")
    private String url;
    @Value("${atguigu.driver}")
    private String driver;
    @Value("${atguigu.username}")
    private String username;
    @Value("${atguigu.password}")
    private String password;


    // 第三方类组件，替代XML的第三方组件配置
    @Bean
    public DruidDataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
