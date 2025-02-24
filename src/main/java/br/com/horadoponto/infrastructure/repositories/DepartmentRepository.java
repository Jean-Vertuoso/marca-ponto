package br.com.horadoponto.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.horadoponto.infrastructure.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}