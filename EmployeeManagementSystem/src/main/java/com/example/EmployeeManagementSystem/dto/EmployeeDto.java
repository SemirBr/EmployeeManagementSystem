package com.example.EmployeeManagementSystem.dto;

import com.example.EmployeeManagementSystem.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private Long id;
    private List<Project> projects;
    private String firstName;
    private String lastName;
    private String email;
}
