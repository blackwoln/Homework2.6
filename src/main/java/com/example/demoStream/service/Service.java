package com.example.demoStream.service;

import com.example.demoStream.model.Employee;

import java.util.List;

public interface Service {
    Employee findEmployeeWithMaxSalaryByDepartment(int department);

    Employee findEmployeeWithMinSalaryByDepartment(int department);

    List<Employee> findAllEmployeesByDepartment(int department);

    List<Employee> findAllEmployeesWithDepartments();
}
