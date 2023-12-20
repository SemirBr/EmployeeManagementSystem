package com.example.EmployeeManagementSystem.service;

import com.example.EmployeeManagementSystem.dto.ProjectDto;

import java.util.List;

public interface ProjectService {
    ProjectDto createProject(ProjectDto projectDto);
    ProjectDto getProjectById(Long projectId);
    List<ProjectDto> getAllProjects();

    ProjectDto updateProject(Long projectId, ProjectDto updateProject);

    void deleteProject(Long projectId);
}
