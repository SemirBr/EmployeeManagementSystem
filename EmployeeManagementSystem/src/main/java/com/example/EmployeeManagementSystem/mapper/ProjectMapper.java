package com.example.EmployeeManagementSystem.mapper;

import com.example.EmployeeManagementSystem.dto.ProjectDto;
import com.example.EmployeeManagementSystem.entity.Project;

public class ProjectMapper {

    public static ProjectDto mapToProjectDto(Project project) {
        return new ProjectDto(
                project.getId(),
                project.getEmployee(),
                project.getNameOfProject(),
                project.getDateFrom(),
                project.getDateTo()
        );
    }
    public static Project mapToProject(ProjectDto projectDto) {
        return new Project(
                projectDto.getId(),
                projectDto.getEmployee(),
                projectDto.getNameOfProject(),
                projectDto.getDateFrom(),
                projectDto.getDateTo()
        );


    }
}
