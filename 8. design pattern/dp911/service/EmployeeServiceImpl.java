package main.dp911.service;

import main.dp911.model.Employee;
import main.dp911.db.DBConnection;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1L, "eslam", "pass123", 26));
        employees.add(new Employee(2L, "ahmed", "ahmed123", 30));
        employees.add(new Employee(3L, "mohamed", "mohamed123", 28));
        employees.add(new Employee(4L, "sara", "sara123", 24));
        employees.add(new Employee(5L, "ali", "ali123", 35));
        return employees;

    }
}
