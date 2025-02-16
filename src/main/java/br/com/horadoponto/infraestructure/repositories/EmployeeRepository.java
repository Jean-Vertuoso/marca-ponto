package br.com.horadoponto.infraestructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.horadoponto.infraestructure.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
