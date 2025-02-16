package br.com.horadoponto.horadoponto.infraestructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.horadoponto.horadoponto.infraestructure.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}