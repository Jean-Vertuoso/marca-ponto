package br.com.horadoponto.horadoponto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.horadoponto.horadoponto.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
