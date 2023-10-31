package org.example.config;

// 初始化ioc容器，设置dispatcherServlet的地址

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringMvcInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 指定service / mapper层的配置类
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    /**
     * 指定springmvc的配置类
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { MvcConfig.class };
    }

    /**
     * 设置dispatcherServlet的处理路径!
     * 一般情况下为 / 代表处理所有请求!
     */
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
