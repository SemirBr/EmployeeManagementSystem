package com.example.EmployeeManagementSystem.dto;

import com.example.EmployeeManagementSystem.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeePairsDto {
    private Long employeeId1;
    private Long employeeId2;
    private Long totalDuration;
}
