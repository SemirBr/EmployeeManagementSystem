package com.example.EmployeeManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @Column(name="name_of_project")
    private String nameOfProject;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dateFrom;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dateTo;
}
