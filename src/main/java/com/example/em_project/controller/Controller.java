package com.example.em_project.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.em_project.model.Employee;
import com.example.em_project.service.EmployeeService;
import com.example.em_project.service.EmployeeServiceImplem;



@RestController
public class Controller {

    // @Autowired
    // EmployeeService es;   // Dependencies Innjection (DI) :- no need to create objects everytime manually
    
    // This is the best way using constructor, as compared to @AutoWired
    EmployeeService employeeService = new EmployeeServiceImplem();
    public Controller(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    

    @GetMapping("employees")
    public List<Employee>getAllEmployee() {
        return employeeService.readEmployees();
    }

    @GetMapping("employees/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {  
        return employeeService.readEmployee(id);
    }


    @PostMapping("employees")
    public String createEmployee(@RequestBody Employee employee) { // RequestBody - because taking object from other file, not in input by user
        return employeeService.createEmployee(employee);
    }
    
    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        if(employeeService.deleteEmployee(id)) return "Deleted successfully";
        return "Not Found";
    }

    @PutMapping("employees/{id}")
    public String updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }
} 
