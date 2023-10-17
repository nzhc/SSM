package com.atguigu.ioc_03;

import org.springframework.beans.factory.FactoryBean;

/**
 * Description:
 *
 * @Create:2023/10/16 - 20:52
 */
public class JavaBeanFactoryBean implements FactoryBean<JavaBean> {
    @Override
    public JavaBean getObject() throws Exception {
        // 自定义方式实例化对象
        JavaBean javaBean = new JavaBean();
        return javaBean;
    }

    @Override
    public Class<?> getObjectType() {
        return JavaBean.class;
    }
}
