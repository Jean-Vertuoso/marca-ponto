package br.com.horadoponto.horadoponto.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.horadoponto.horadoponto.entities.Department;
import br.com.horadoponto.horadoponto.entities.Employee;
import br.com.horadoponto.horadoponto.entities.enums.EmployeeStatus;
import br.com.horadoponto.horadoponto.repositories.DepartmentRepository;
import br.com.horadoponto.horadoponto.repositories.EmployeeRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    EmployeeRepository empRepository;

    @Autowired
    DepartmentRepository deptRepository;

    @Override
    public void run(String... args) throws Exception {

        Department dept1 = new Department(null, "Gerência de produto");
        Department dept2 = new Department(null, "Suporte técnico");
        Department dept3 = new Department(null, "Marketing");
        Department dept4 = new Department(null, "Vendas");

        deptRepository.saveAll(Arrays.asList(dept1, dept2, dept3, dept4));

        Employee emp1 = new Employee(null, "Jean da Rocha Vertuoso", "jean_b123@hotmail.com", "48998146654", LocalDate.of(1997,12,26), "123456", dept1, EmployeeStatus.AWAY);
        Employee emp2 = new Employee(null, "Bruna Floriano Porfírio Vertuoso", "bruna@gmail.com", "48998877665", LocalDate.of(1970,01,01), "123456", dept3, EmployeeStatus.AWAY);
        Employee emp3 = new Employee(null, "Gustavo Martignago Crispim dos Santos", "gustavo@gmail.com", "48998776655", LocalDate.of(1970,01,01), "123456", dept2, EmployeeStatus.WORKING);
        Employee emp4 = new Employee(null, "Jose Vertuoso", "jose@gmail.com", "48999887766", LocalDate.of(1970,01,01), "123456", dept4, EmployeeStatus.ANNUAL_LEAVE);

        empRepository.saveAll(Arrays.asList(emp1, emp2, emp3, emp4));

    }
}
