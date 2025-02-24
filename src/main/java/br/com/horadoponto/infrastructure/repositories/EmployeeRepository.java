package br.com.horadoponto.infrastructure.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.horadoponto.infrastructure.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    boolean existsByEmail(String email);

    Optional<Employee> findByEmail(String email);
}
