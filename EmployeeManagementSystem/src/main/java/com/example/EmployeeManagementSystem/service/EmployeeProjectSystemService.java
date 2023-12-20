package com.example.EmployeeManagementSystem.service;

import com.example.EmployeeManagementSystem.dto.EmployeeProjectSystemDto;

import java.util.List;

public interface EmployeeProjectSystemService {
    EmployeeProjectSystemDto createEmployeeProjectSystem(EmployeeProjectSystemDto employeeProjectSystemDto);
    EmployeeProjectSystemDto getEmployeeProjectSystemById(Long employeeProjectSystemId);
    List<EmployeeProjectSystemDto> getAllEmployeeProjectSystems();

    EmployeeProjectSystemDto updateEmployeeProjectSystem(Long employeeProjectSystemId, EmployeeProjectSystemDto updatedEmployeeProjectSystem);

    void deleteEmployeeProjectSystem(Long employeeProjectSystemId);
}
