package br.com.horadoponto.controllers.dto;

import br.com.horadoponto.infrastructure.entities.Department;
import br.com.horadoponto.infrastructure.entities.Employee;

import java.util.ArrayList;
import java.util.List;

public class DepartmentDTO {

    private Long id;
    private String name;

    public DepartmentDTO() {
    }

    public DepartmentDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}