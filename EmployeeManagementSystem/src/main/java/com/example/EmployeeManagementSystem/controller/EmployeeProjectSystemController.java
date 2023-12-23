package com.example.EmployeeManagementSystem.controller;

import com.example.EmployeeManagementSystem.dto.EmployeePairsDto;
import com.example.EmployeeManagementSystem.dto.EmployeeProjectSystemDto;
import com.example.EmployeeManagementSystem.entity.EmployeeProjectSystem;
import com.example.EmployeeManagementSystem.service.EmployeeProjectSystemService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employee-project-systems")
@Validated
public class EmployeeProjectSystemController {

    private final EmployeeProjectSystemService employeeProjectSystemService;

    @PostMapping
    public ResponseEntity<EmployeeProjectSystemDto> createEmployeeProjectSystem(@Valid @RequestBody EmployeeProjectSystemDto employeeProjectSystemDto) {
        EmployeeProjectSystemDto savedEmployeeProjectSystem = employeeProjectSystemService.createEmployeeProjectSystem(employeeProjectSystemDto);
        return new ResponseEntity<>(savedEmployeeProjectSystem, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeProjectSystemDto> getEmployeeProjectSystemById(@PathVariable("id") Long employeeProjectSystemId) {
        EmployeeProjectSystemDto employeeProjectSystemDto = employeeProjectSystemService.getEmployeeProjectSystemById(employeeProjectSystemId);
        return ResponseEntity.ok(employeeProjectSystemDto);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeProjectSystem>> getAllEmployeeProjectSystems() {
        return ResponseEntity.ok(employeeProjectSystemService.getAllEmployeeProjectSystems());
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeProjectSystemDto> updateEmployeeProjectSystem(@PathVariable("id") Long employeeProjectSystemId,
                                                                                @RequestBody EmployeeProjectSystemDto updatedEmployeeProjectSystem) {
        EmployeeProjectSystemDto employeeProjectSystemDto = employeeProjectSystemService.updateEmployeeProjectSystem(employeeProjectSystemId, updatedEmployeeProjectSystem);
        return ResponseEntity.ok(employeeProjectSystemDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployeeProjectSystem(@PathVariable("id") Long employeeProjectSystemId) {
        employeeProjectSystemService.deleteEmployeeProjectSystem(employeeProjectSystemId);
        return ResponseEntity.ok("Employee Project System deleted successfully");
    }
    @GetMapping("/pairs")
    public ResponseEntity<EmployeePairsDto>findLongestWorkingPair(){
        return ResponseEntity.ok(employeeProjectSystemService.findLongestWorkingPair());
    }
}