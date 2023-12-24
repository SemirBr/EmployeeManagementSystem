package com.example.EmployeeManagementSystem.dataloader;

import com.example.EmployeeManagementSystem.dto.EmployeeProjectSystemDto;
import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.entity.EmployeeProjectSystem;
import com.example.EmployeeManagementSystem.entity.Project;
import com.example.EmployeeManagementSystem.repository.EmployeeProjectSystemRepository;
import com.example.EmployeeManagementSystem.repository.EmployeeRepository;
import com.example.EmployeeManagementSystem.repository.ProjectRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class CsvLoader {
    private final EmployeeRepository employeeRepository;
    private final ProjectRepository projectRepository;
    private final EmployeeProjectSystemRepository employeeProjectSystemRepository;
    public static final String database = "src/main/resources/data.csv";
    public static final String pattern = "yyyy-MM-dd";
    public static final ThreadLocal<SimpleDateFormat> sdf = ThreadLocal.withInitial(() -> new SimpleDateFormat(pattern));

    public CsvLoader(EmployeeRepository employeeRepository, ProjectRepository projectRepository, EmployeeProjectSystemRepository employeeProjectSystemRepository) {
        this.employeeRepository = employeeRepository;
        this.projectRepository = projectRepository;
        this.employeeProjectSystemRepository = employeeProjectSystemRepository;
    }


    @PostConstruct
   void init(){
       listEmployee();
   }
    public void listEmployee() {


        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(database))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] employeeData = line.split(",");
                long employeeId = Long.parseLong(employeeData[0]);
                long projectId = Long.parseLong(employeeData[1]);
                Date dateFrom;
                Date dateTo;
                try {
                    dateFrom = sdf.get().parse(employeeData[2]);
                    dateTo = sdf.get().parse(employeeData[3]);
                } catch (ParseException e) {
                    dateFrom = new Date(System.currentTimeMillis());
                    dateTo = new Date(System.currentTimeMillis());
                }
                EmployeeProjectSystemDto employeeProjectSystemDto = new EmployeeProjectSystemDto();
                employeeProjectSystemDto.setEmployeeId(employeeId);
                employeeProjectSystemDto.setProjectId(projectId);
                employeeProjectSystemDto.setDateFrom(dateFrom);
                employeeProjectSystemDto.setDateTo(dateTo);
                checkExisting(employeeProjectSystemDto);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void checkExisting(EmployeeProjectSystemDto employeeProjectSystemDto) {
        Optional<Employee> employee = employeeRepository.findById(employeeProjectSystemDto.getEmployeeId());
        Optional<Project> project = projectRepository.findById(employeeProjectSystemDto.getProjectId());
        if (project.isPresent() && employee.isPresent()) {
            EmployeeProjectSystem employeeProjectSystem = new EmployeeProjectSystem();
            employeeProjectSystem.setEmployee(employee.get());
            employeeProjectSystem.setProject(project.get());
            employeeProjectSystem.setDateFrom(employeeProjectSystemDto.getDateFrom());
            employeeProjectSystem.setDateTo(employeeProjectSystemDto.getDateTo());
            List<EmployeeProjectSystem> projectSystemList = employeeProjectSystemRepository.findByEmployeeAndProjectAndDateFromAndDateTo(employee.get(), project.get(), employeeProjectSystemDto.getDateFrom(), employeeProjectSystemDto.getDateTo());
            if (!projectSystemList.isEmpty()) {
                return;
            }
            employeeProjectSystemRepository.save(employeeProjectSystem);
        }
    }

}
