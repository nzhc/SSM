package org.example.mapper;

import org.example.pojo.Employee;

import java.util.List;

/**
 * projectName: com.atguigu.mapper
 *
 * @author: 赵伟风
 * description:
 */
public interface EmployeeMapper {

    //查询全部员工信息
    List<Employee> queryList();
}
