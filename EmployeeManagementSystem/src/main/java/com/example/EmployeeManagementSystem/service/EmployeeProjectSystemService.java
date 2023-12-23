package com.example.EmployeeManagementSystem.service;

import com.example.EmployeeManagementSystem.dto.EmployeePairsDto;
import com.example.EmployeeManagementSystem.dto.EmployeeProjectSystemDto;
import com.example.EmployeeManagementSystem.entity.EmployeeProjectSystem;

import java.util.List;

public interface EmployeeProjectSystemService {
    EmployeeProjectSystemDto createEmployeeProjectSystem(EmployeeProjectSystemDto employeeProjectSystemDto);
    EmployeeProjectSystemDto getEmployeeProjectSystemById(Long employeeProjectSystemId);
    List<EmployeeProjectSystem> getAllEmployeeProjectSystems();

    EmployeeProjectSystemDto updateEmployeeProjectSystem(Long employeeProjectSystemId, EmployeeProjectSystemDto updatedEmployeeProjectSystem);

    void deleteEmployeeProjectSystem(Long employeeProjectSystemId);

    EmployeePairsDto findLongestWorkingPair();
}
