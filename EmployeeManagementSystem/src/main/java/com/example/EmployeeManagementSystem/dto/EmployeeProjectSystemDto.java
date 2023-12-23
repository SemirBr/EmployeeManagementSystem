package com.example.EmployeeManagementSystem.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeProjectSystemDto {
    private Long id;
    @NotNull(message = "Employee ID cannot be blank")
    private Long employeeId;
    @NotNull(message = "Project ID cannot be blank")
    private Long projectId;
    private Date dateFrom;
    private Date dateTo;
}
