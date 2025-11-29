// MODEL

package com.example.em_project.model;

import lombok.Data;

@Data // automatically handle all getters and setters
public
class Employee {
    private Long id;
    private String name;
    private String email;
    private String phone;
} 
