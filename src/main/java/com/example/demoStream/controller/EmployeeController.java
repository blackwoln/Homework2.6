package com.example.demoStream.controller;

import com.example.demoStream.model.Employee;
import com.example.demoStream.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/departments/max-salary")
    public Employee findEmployeeWithMaxSalaryByDepartment(@RequestParam int departmentId) {
        return employeeService.findEmployeeWithMaxSalaryByDepartment(departmentId);
    }

    @GetMapping("/departments/min-salary")
    public Employee findEmployeeWithMinSalaryByDepartment(@RequestParam int departmentId) {
        return employeeService.findEmployeeWithMinSalaryByDepartment(departmentId);
    }

    @GetMapping("/departments/all")
    public List<Employee> findAllEmployeesByDepartment(@RequestParam(required = false) Integer departmentId) {
        if (departmentId != null) {
            return employeeService.findAllEmployeesByDepartment(departmentId);
        } else {
            return employeeService.findAllEmployeesWithDepartments();
        }
    }
}
