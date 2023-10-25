package org.example.mapper;

import org.example.pojo.Employee;

import java.util.Map;

public interface EmployeeMapper {

    // dml命令可以使用int返回值
    int deleteById(Integer id);

    // 根据员工id查询员工姓名
    String queryNameById(Integer id);

    Employee queryById(Integer id);

    Map<String,Object> selectEmpNameAndMaxSalary();
}
