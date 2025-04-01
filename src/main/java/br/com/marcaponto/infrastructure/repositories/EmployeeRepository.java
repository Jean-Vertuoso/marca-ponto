package br.com.marcaponto.infrastructure.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.marcaponto.infrastructure.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    boolean existsByEmail(String email);

    Optional<Employee> findByEmail(String email);

    @Query(nativeQuery = true, value= """
            SELECT * FROM tb_employee emp 
            WHERE UPPER(emp.name) LIKE UPPER(CONCAT('%', :name, '%'))
            """)
    List<Employee> findByNameIgnoreCase(String name);
}