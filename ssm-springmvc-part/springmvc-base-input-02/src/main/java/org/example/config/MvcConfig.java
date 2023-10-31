package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@EnableWebMvc   // 配置json,自动配置RequestMappingHandlerMapping和RequestMappingHandlerAdapter
@Configuration
@ComponentScan("org.example.jsp")
public class MvcConfig implements WebMvcConfigurer {
//    @Bean
//    public RequestMappingHandlerMapping handlerMapping(){
//        return new RequestMappingHandlerMapping();
//    }
//
//    @Bean
//    public RequestMappingHandlerAdapter handlerAdapter(){
//        return new RequestMappingHandlerAdapter();
//    }

    // 配置视图解析器，配置前后缀
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry){
        // register配置前后缀
        registry.jsp("/WEB-INF/views/", ".jsp");

    }

    // 配置允许外部访问webapp下的静态资源，本质上是在HandlerMapping外增加了一个Mapping，用来查找静态资源
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
