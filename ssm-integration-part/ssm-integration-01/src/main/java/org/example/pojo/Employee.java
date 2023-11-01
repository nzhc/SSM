package org.example.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Employee {
    private Integer empId;
    private String empName;
    private Double empSalary;
}
