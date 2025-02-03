package br.com.horadoponto.horadoponto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.horadoponto.horadoponto.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}