package com.example.em_project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data   // automatically provide getter and setter methods
@Entity
@Table(name="employee")   // if we change this table name and run this project, then a new table will be created in mysql workbench
public class EmployeeEntity {

    @Id  // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // how primary key is generated
    private Long id;

    private String name;
    private String email;
    private String phone;
}
 