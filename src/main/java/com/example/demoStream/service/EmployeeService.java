package com.example.demoStream.service;

import com.example.demoStream.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService implements com.example.demoStream.service.Service {
    private Employee[] employees;

    public EmployeeService() {
        employees = new Employee[10];
        employees[0] = new Employee("Иванов Иван Иванович", 1, 45000);
        employees[1] = new Employee("Петров Петр Петрович", 2, 46000);
        employees[2] = new Employee("Сидоров Сидор Сидорович", 1, 54500);
        employees[3] = new Employee("Смирнова Елена Александровна", 3, 67000);
        employees[4] = new Employee("Козлова Ольга Владимировна", 2, 55500);
        employees[5] = new Employee("Николаев Николай Николаевич", 4, 88000);
        employees[6] = new Employee("Федорова Екатерина Ивановна", 2, 95000);
        employees[7] = new Employee("Алексеев Алексей Алексеевич", 3, 56500);
        employees[8] = new Employee("Михайлова Мария Петровна", 5, 67500);
        employees[9] = new Employee("Васильев Василий Васильевич", 4, 75500);

    }
    @Override
    public Employee findEmployeeWithMaxSalaryByDepartment(int department) {
        return Arrays.stream(employees)
                .filter(e -> e != null && e.getDepartment() == department)
                .max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                .orElse(null);
    }

    @Override
    public Employee findEmployeeWithMinSalaryByDepartment(int department) {
        return Arrays.stream(employees)
                .filter(e -> e != null && e.getDepartment() == department)
                .min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                .orElse(null);
    }

    @Override
    public List<Employee> findAllEmployeesByDepartment(int department) {
        return Arrays.stream(employees)
                .filter(e -> e != null && e.getDepartment() == department)
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> findAllEmployeesWithDepartments() {
        return Arrays.stream(employees)
                .filter(e -> e != null)
                .distinct()
                .collect(Collectors.toList());
    }
}

