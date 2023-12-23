package com.example.EmployeeManagementSystem.service.impl;

import com.example.EmployeeManagementSystem.dateHandler.DateConverter;
import com.example.EmployeeManagementSystem.dto.EmployeePairsDto;
import com.example.EmployeeManagementSystem.dto.EmployeeProjectSystemDto;
import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.entity.EmployeeProjectSystem;
import com.example.EmployeeManagementSystem.entity.Project;
import com.example.EmployeeManagementSystem.exception.ResourceNotFoundException;
import com.example.EmployeeManagementSystem.mapper.EmployeeProjectSystemMapper;
import com.example.EmployeeManagementSystem.repository.EmployeeProjectSystemRepository;
import com.example.EmployeeManagementSystem.repository.EmployeeRepository;
import com.example.EmployeeManagementSystem.repository.ProjectRepository;
import com.example.EmployeeManagementSystem.service.EmployeeProjectSystemService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EmployeeProjectSystemServiceImpl implements EmployeeProjectSystemService {
    private final EmployeeProjectSystemRepository employeeProjectSystemRepository;
    private final EmployeeRepository employeeRepository;
    private final ProjectRepository projectRepository;
    private final DateConverter dateConverter;

    public EmployeeProjectSystemServiceImpl(EmployeeProjectSystemRepository employeeProjectSystemRepository, EmployeeRepository employeeRepository, ProjectRepository projectRepository, DateConverter dateConverter) {
        this.employeeProjectSystemRepository = employeeProjectSystemRepository;
        this.employeeRepository = employeeRepository;
        this.projectRepository = projectRepository;
        this.dateConverter = dateConverter;
    }

    @Override
    public EmployeeProjectSystemDto createEmployeeProjectSystem(EmployeeProjectSystemDto employeeProjectSystemDto) {
        if (employeeProjectSystemDto.getDateFrom()==null){
            employeeProjectSystemDto.setDateFrom(new Date(System.currentTimeMillis()));
        }  if (employeeProjectSystemDto.getDateTo()==null){
            employeeProjectSystemDto.setDateTo(new Date(System.currentTimeMillis()));
        }
        Employee employee = employeeRepository.findById(employeeProjectSystemDto.getEmployeeId()).orElseThrow(()->new ResourceNotFoundException("Employee with the given id does not exist"));
        Project project =projectRepository.findById(employeeProjectSystemDto.getProjectId()).orElseThrow(()-> new ResourceNotFoundException("Project with given id does not exist"));
        EmployeeProjectSystem employeeProjectSystem = EmployeeProjectSystemMapper.mapToEmployeeProjectSystem(employeeProjectSystemDto,employee,project);
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
    public List<EmployeeProjectSystem> getAllEmployeeProjectSystems() {
        return employeeProjectSystemRepository.findAll();

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

    @Override
    public EmployeePairsDto findLongestWorkingPair() {
        List<Object[]> result = employeeProjectSystemRepository.findLongestWorkingPair();

        if (!result.isEmpty()) {
            Object[] row = result.get(0);

            Long employeeId1 = ((Number) row[0]).longValue();
            Long employeeId2 = ((Number) row[1]).longValue();
            Long totalDuration = ((Number) row[2]).longValue();

            return new EmployeePairsDto(employeeId1, employeeId2, totalDuration);

        }
        throw new ResourceNotFoundException("There are no pairs that worked together!");
    }
}
