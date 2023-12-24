package com.example.EmployeeManagementSystem.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
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

    @NotNull(message = "Date From cannot be null")
    @PastOrPresent(message = "Date From should be in the past or present")
    private Date dateFrom;

    @PastOrPresent(message = "Date To should be in the past or present")
    private Date dateTo;
}
