/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.em_project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.em_project.model.Employee;
import com.example.em_project.model.EmployeeEntity;
import com.example.em_project.repository.EmployeeRepository;

@Service
public class EmployeeServiceImplem implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // List<Employee> employees = new ArrayList<>();

    @Override
    public String createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepository.save(employeeEntity);

        return "Saved successfully";
    }

    @Override
    public Employee readEmployee(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();

        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity, employee);

        return employee;
    }
 
    @Override
    public List<Employee> readEmployees() {
        List<EmployeeEntity> employeesList = employeeRepository.findAll();
        List<Employee> employees = new ArrayList<>();

        for(EmployeeEntity employeeEntity : employeesList) {

            Employee emp = new Employee();
            // emp.setId(employeeEntity.getId());
            // emp.setName(employeeEntity.getName());
            // emp.setEmail(employeeEntity.getEmail());
            // emp.setPhone(employeeEntity.getPhone());

            // Also we can use this "BeanUtils" insted of deep copy.
            BeanUtils.copyProperties(employeeEntity, emp);
            employees.add(emp);
        }
        return employees;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        
        EmployeeEntity emp = employeeRepository.findById(id).get();
        employeeRepository.delete(emp);

        return true;
    }

    @Override
    public String updateEmployee(Long id, Employee employee) {
        EmployeeEntity existingEmployee = employeeRepository.findById(id).get();
        // existingEmployee.setEmail(employee.getEmail());
        // existingEmployee.setName(employee.getName());
        // existingEmployee.setPhone(employee.getPhone());

        // Also we can use this "BeanUtils" insted of deep copy.
        BeanUtils.copyProperties(employee, existingEmployee);        
        employeeRepository.save(existingEmployee);

        return "Update successfully";
    }

}
