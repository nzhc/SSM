package com.atguigu.dao;

import com.atguigu.pojo.Student;

import java.util.List;

/**
 * Description:
 *
 * @Create:2023/10/16 - 22:02
 */
public interface StudentDao {
    List<Student> queryAll();
}
