package br.com.horadoponto.infraestructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.horadoponto.infraestructure.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}