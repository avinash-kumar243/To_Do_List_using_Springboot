// Service Layer

package com.example.em_project.service;

import java.util.List;

import com.example.em_project.model.Employee;

public interface EmployeeService {
    // Create an employee
    String createEmployee(Employee e);

    // Read an employees
    Employee readEmployee(Long id);

    // Read all employees
    List<Employee> readEmployees();
    
    // Update an employee
    String updateEmployee(Long id, Employee employee);
    
    // Delete an employee
    boolean deleteEmployee(Long id);
    
} 
