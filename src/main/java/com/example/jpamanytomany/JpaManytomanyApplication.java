package com.example.jpamanytomany;

import com.example.jpamanytomany.entities.Employee;
import com.example.jpamanytomany.entities.EmployeeRepository;
import com.example.jpamanytomany.entities.Project;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class JpaManytomanyApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(JpaManytomanyApplication.class, args);
//        EmployeeRepository employeeRepository = ctx.getBean(EmployeeRepository.class);
//        ProjectRepository projectRepository = ctx.getBean(ProjectRepository.class);
//
//        Project alfa = new Project("alfa");
//        Project beta = new Project("beta");
//        Project gamma = new Project("gamma");
//
////        projectRepository.saveAll(Arrays.asList(alfa, beta, gamma));
//
//        Employee basarab = new Employee("Basarab");
//        Employee neagoe = new Employee("Neagoe");
//
//        basarab.addProject(alfa);
//        basarab.addProject(beta);
//        basarab.addProject(gamma);
//        neagoe.addProject(alfa);
//        neagoe.addProject(gamma);
//
//        employeeRepository.saveAll(Arrays.asList(basarab, neagoe));
    }

    @Bean
    public CommandLineRunner runner(EmployeeRepository repository) {
        return args -> {
            Employee basarab = new Employee("Basarab");
            Employee neagoe = new Employee("Neagoe");

            Project project = new Project("alfa");
            Project project1 = new Project("beta");
            Project project2 = new Project("gamma");

            basarab.addProject(project);
            basarab.addProject(project1);

            neagoe.addProject(project);

            repository.saveAll(Arrays.asList(basarab, neagoe));
        };
    }
}
