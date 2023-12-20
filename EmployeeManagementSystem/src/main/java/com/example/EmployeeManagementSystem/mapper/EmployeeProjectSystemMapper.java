package com.example.EmployeeManagementSystem.mapper;

import com.example.EmployeeManagementSystem.dto.EmployeeProjectSystemDto;
import com.example.EmployeeManagementSystem.entity.EmployeeProjectSystem;

public class EmployeeProjectSystemMapper {
    public static EmployeeProjectSystemDto mapToEmployeeProjectSystemDto(EmployeeProjectSystem employeeProjectSystem){
        return new EmployeeProjectSystemDto(
                employeeProjectSystem.getId(),
                employeeProjectSystem.getEmployee(),
                employeeProjectSystem.getProjects(),
                employeeProjectSystem.getDateFrom(),
                employeeProjectSystem.getDateTo()
        );
    }

    public static EmployeeProjectSystem mapToEmployeeProjectSystem(EmployeeProjectSystemDto employeeProjectSystemDto){
        return new EmployeeProjectSystem(
                employeeProjectSystemDto.getId(),
                employeeProjectSystemDto.getEmployee(),
                employeeProjectSystemDto.getProjects(),
                employeeProjectSystemDto.getDateFrom(),
                employeeProjectSystemDto.getDateTo()
        );
    }
}
