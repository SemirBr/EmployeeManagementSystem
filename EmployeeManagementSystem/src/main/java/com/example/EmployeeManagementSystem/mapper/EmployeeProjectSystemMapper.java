package com.example.EmployeeManagementSystem.mapper;

import com.example.EmployeeManagementSystem.dto.EmployeeProjectSystemDto;
import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.entity.EmployeeProjectSystem;
import com.example.EmployeeManagementSystem.entity.Project;

public class EmployeeProjectSystemMapper {
    public static EmployeeProjectSystemDto mapToEmployeeProjectSystemDto(EmployeeProjectSystem employeeProjectSystem){
        return new EmployeeProjectSystemDto(
                employeeProjectSystem.getId(),
                employeeProjectSystem.getEmployee().getId(),
                employeeProjectSystem.getProject().getId(),
                employeeProjectSystem.getDateFrom(),
                employeeProjectSystem.getDateTo()
        );
    }

    public static EmployeeProjectSystem mapToEmployeeProjectSystem(EmployeeProjectSystemDto employeeProjectSystemDto, Employee employee, Project project){
        return new EmployeeProjectSystem(
                employeeProjectSystemDto.getId(),
                employee,
                project,
                employeeProjectSystemDto.getDateFrom(),
                employeeProjectSystemDto.getDateTo()
        );
    }
}
