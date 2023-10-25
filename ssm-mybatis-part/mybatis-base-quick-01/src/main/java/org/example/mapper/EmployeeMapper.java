package org.example.mapper;

import org.example.pojo.Employee;

public interface EmployeeMapper {

    public Employee queryById(Integer id);

    public void deleteById(Integer id);
}
