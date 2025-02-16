package br.com.horadoponto.infraestructure.config;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.horadoponto.infraestructure.entities.Department;
import br.com.horadoponto.infraestructure.entities.Employee;
import br.com.horadoponto.infraestructure.entities.enums.EmployeeStatus;
import br.com.horadoponto.infraestructure.entities.TimeEntry;
import br.com.horadoponto.infraestructure.repositories.DepartmentRepository;
import br.com.horadoponto.infraestructure.repositories.EmployeeRepository;
import br.com.horadoponto.infraestructure.repositories.TimeEntryRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    EmployeeRepository empRepository;

    @Autowired
    DepartmentRepository deptRepository;

    @Autowired
    TimeEntryRepository tmEntRepository;

    @Override
    public void run(String... args) throws Exception {

        Department dept1 = new Department(null, "Gerência de produto");
        Department dept2 = new Department(null, "Suporte técnico");
        Department dept3 = new Department(null, "Marketing");
        Department dept4 = new Department(null, "Vendas");

        deptRepository.saveAll(Arrays.asList(dept1, dept2, dept3, dept4));

        Employee emp1 = new Employee(null, "Jean da Rocha Vertuoso", "jean@gmail.com", LocalDate.of(1972,3,01), "123456", dept1, EmployeeStatus.AWAY);
        Employee emp2 = new Employee(null, "Gustavo Martignago Crispim dos Santos", "gustavo@gmail.com", LocalDate.of(1981,5,13), "123456", dept2, EmployeeStatus.WORKING);
        Employee emp3 = new Employee(null, "Raymond Francis Boyce", "raymond@gmail.com", LocalDate.of(1946,8,27), "123456", dept3, EmployeeStatus.AWAY);
        Employee emp4 = new Employee(null, "James Gosling", "james@gmail.com", LocalDate.of(1956,5,19), "123456", dept4, EmployeeStatus.ANNUAL_LEAVE);

        empRepository.saveAll(Arrays.asList(emp1, emp2, emp3, emp4));

        TimeEntry te011 = new TimeEntry(null, Instant.now(), emp2);
        TimeEntry te101 = new TimeEntry(null, Instant.now(), emp4);
        TimeEntry te111 = new TimeEntry(null, Instant.now(), emp1);

        tmEntRepository.saveAll(Arrays.asList(te011, te101, te111));
    }
}