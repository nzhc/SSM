package com.atguigu.controller;

import com.atguigu.pojo.Student;
import com.atguigu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Description:
 *
 * @Create:2023/10/16 - 22:11
 */
@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

//    public void setStudentService(StudentService studentService) {
//        this.studentService = studentService;
//    }

    public void findAll(){
        List<Student> studentList = studentService.findAll();
        System.out.println(studentList);
    }
}
