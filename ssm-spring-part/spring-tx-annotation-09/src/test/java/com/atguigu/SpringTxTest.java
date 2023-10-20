package com.atguigu;

import com.atguigu.config.JavaConfig;
import com.atguigu.dao.StudentDao;
import com.atguigu.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.io.FileNotFoundException;

@SpringJUnitConfig(JavaConfig.class)
public class SpringTxTest {
    @Autowired
    private StudentService studentService;

    @Test
    public void test() throws FileNotFoundException {
        studentService.changeInfo();
    }
}
