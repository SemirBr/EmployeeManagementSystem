package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.entity.EmployeeProjectSystem;
import com.example.EmployeeManagementSystem.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface EmployeeProjectSystemRepository extends JpaRepository<EmployeeProjectSystem, Long> {

    @Query(value = "SELECT EP1.employee.id AS employeeId1, EP2.employee.id AS employeeId2, " +
            "SUM(DATEDIFF(LEAST(EP1.dateTo, EP2.dateTo), GREATEST(EP1.dateFrom, EP2.dateFrom))) AS totalDuration " +
            "FROM EmployeeProjectSystem EP1 " +
            "JOIN EmployeeProjectSystem EP2 ON EP1.project.id = EP2.project.id AND EP1.employee.id < EP2.employee.id " +
            "GROUP BY EP1.employee.id, EP2.employee.id " +
            "ORDER BY totalDuration DESC LIMIT 1")
    List<Object[]> findLongestWorkingPair();

    List<EmployeeProjectSystem> findByEmployeeAndProjectAndDateFromAndDateTo(
            Employee employee,
            Project project,
            Date dateFrom,
            Date dateTo
    );

}
