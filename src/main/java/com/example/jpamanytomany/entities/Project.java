package com.example.jpamanytomany.entities;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Getter
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long project_id;

    private String title;

    @ManyToMany(mappedBy = "projects")
    private Set<Employee> employees = new HashSet<>();

    public Project(String title) {
        this.title = title;
    }

    public Project() {

    }

    public void addEmployee(Employee employee){
        employees.add(employee);
        employee.getProjects().add(this);
    }
}
