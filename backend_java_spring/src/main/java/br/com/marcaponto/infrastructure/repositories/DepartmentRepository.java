package br.com.marcaponto.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.marcaponto.infrastructure.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}