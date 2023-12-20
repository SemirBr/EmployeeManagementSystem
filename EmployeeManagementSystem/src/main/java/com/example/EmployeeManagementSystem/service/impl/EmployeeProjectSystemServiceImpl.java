package com.example.EmployeeManagementSystem.service.impl;

import com.example.EmployeeManagementSystem.dto.EmployeeProjectSystemDto;
import com.example.EmployeeManagementSystem.entity.EmployeeProjectSystem;
import com.example.EmployeeManagementSystem.exception.ResourceNotFoundException;
import com.example.EmployeeManagementSystem.mapper.EmployeeProjectSystemMapper;
import com.example.EmployeeManagementSystem.repository.EmployeeProjectSystemRepository;
import com.example.EmployeeManagementSystem.service.EmployeeProjectSystemService;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeProjectSystemServiceImpl implements EmployeeProjectSystemService {
    private final EmployeeProjectSystemRepository employeeProjectSystemRepository;

    public EmployeeProjectSystemServiceImpl(EmployeeProjectSystemRepository employeeProjectSystemRepository) {
        this.employeeProjectSystemRepository = employeeProjectSystemRepository;
    }

    @Override
    public EmployeeProjectSystemDto createEmployeeProjectSystem(EmployeeProjectSystemDto employeeProjectSystemDto) {
        EmployeeProjectSystem employeeProjectSystem = EmployeeProjectSystemMapper.mapToEmployeeProjectSystem(employeeProjectSystemDto);
        EmployeeProjectSystem savedEmployeeProjectSystem = employeeProjectSystemRepository.save(employeeProjectSystem);
        return EmployeeProjectSystemMapper.mapToEmployeeProjectSystemDto(savedEmployeeProjectSystem);
    }

    @Override
    public EmployeeProjectSystemDto getEmployeeProjectSystemById(Long employeeProjectSystemId) {
        EmployeeProjectSystem employeeProjectSystem = employeeProjectSystemRepository.findById(employeeProjectSystemId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee Project System does not exist with the given ID: " + employeeProjectSystemId));
        return EmployeeProjectSystemMapper.mapToEmployeeProjectSystemDto(employeeProjectSystem);
    }

    @Override
    public List<EmployeeProjectSystemDto> getAllEmployeeProjectSystems() {
        List<EmployeeProjectSystem> employeeProjectSystems = employeeProjectSystemRepository.findAll();
        return employeeProjectSystems.stream()
                .map(EmployeeProjectSystemMapper::mapToEmployeeProjectSystemDto)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeProjectSystemDto updateEmployeeProjectSystem(Long employeeProjectSystemId, EmployeeProjectSystemDto updatedEmployeeProjectSystem) {
        EmployeeProjectSystem employeeProjectSystem = employeeProjectSystemRepository.findById(employeeProjectSystemId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee Project System does not exist with the given ID: " + employeeProjectSystemId));
        employeeProjectSystem.setDateFrom(updatedEmployeeProjectSystem.getDateFrom());
        employeeProjectSystem.setDateTo(updatedEmployeeProjectSystem.getDateTo());

        EmployeeProjectSystem updatedEmployeeProjectSystemEntity = employeeProjectSystemRepository.save(employeeProjectSystem);
        return EmployeeProjectSystemMapper.mapToEmployeeProjectSystemDto(updatedEmployeeProjectSystemEntity);
    }


    @Override
    public void deleteEmployeeProjectSystem(Long employeeProjectSystemId) {
        employeeProjectSystemRepository.deleteById(employeeProjectSystemId);
    }
}
