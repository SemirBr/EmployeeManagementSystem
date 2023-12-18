package com.example.EmployeeManagementSystem.dto;

import com.example.EmployeeManagementSystem.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {
    private long id;
    private Employee employee;
    private String nameOfProject;
    private Date dateFrom;
    private Date dateTo;
}
