package br.com.horadoponto.horadoponto.config;

import java.time.LocalDate;
import java.util.Arrays;

import br.com.horadoponto.horadoponto.entities.Employee;
import br.com.horadoponto.horadoponto.entities.enums.EmployeeStatus;
import br.com.horadoponto.horadoponto.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    EmployeeRepository empRepository;

    @Override
    public void run(String... args) throws Exception {

        Employee emp1 = new Employee(null, "Jean da Rocha Vertuoso", "jean_b123@hotmail.com", "48998146654", LocalDate.of(1997,12,26), "123456", EmployeeStatus.valueOf("AWAY"));
        Employee emp2 = new Employee(null, "Bruna Floriano Porfírio Vertuoso", "bruna@gmail.com", "48998877665", LocalDate.of(1970,01,01), "123456", EmployeeStatus.valueOf("AWAY"));
        Employee emp3 = new Employee(null, "Gustavo Martignago Crispim dos Santos", "gustavo@gmail.com", "48998776655", LocalDate.of(1970,01,01), "123456", EmployeeStatus.valueOf("WORKING"));
        Employee emp4 = new Employee(null, "Jose Vertuoso", "jose@gmail.com", "48999887766", LocalDate.of(1970,01,01), "123456", EmployeeStatus.valueOf("WORKING"));

        empRepository.saveAll(Arrays.asList(emp1, emp2, emp3, emp4));

    }
}
