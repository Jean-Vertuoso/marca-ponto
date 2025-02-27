package br.com.horadoponto.business.services;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.horadoponto.business.converters.EmployeeConverter;
import br.com.horadoponto.controllers.dto.EmployeeDTO;
import br.com.horadoponto.infrastructure.entities.Employee;
import br.com.horadoponto.infrastructure.exceptions.ConflictException;
import br.com.horadoponto.infrastructure.exceptions.ResourceNotFoundException;
import br.com.horadoponto.infrastructure.repositories.AddressRepository;
import br.com.horadoponto.infrastructure.repositories.DepartmentRepository;
import br.com.horadoponto.infrastructure.repositories.EmployeeRepository;
import br.com.horadoponto.infrastructure.repositories.PhoneRepository;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;
    private DepartmentRepository departmentRepository;
    private AddressRepository addressRepository;
    private PhoneRepository phoneRepository;
    private EmployeeConverter employeeConverter;
    private PasswordEncoder passwordEncoder;

    public EmployeeService(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository, AddressRepository addressRepository, PhoneRepository phoneRepository, EmployeeConverter employeeConverter, PasswordEncoder passwordEncoder) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.addressRepository = addressRepository;
        this.phoneRepository = phoneRepository;
        this.employeeConverter = employeeConverter;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional(readOnly = true)
    public List<EmployeeDTO> findAllEmployees(){
        List<Employee> list = employeeRepository.findAll();
        return list.stream().map(employee -> employeeConverter.toEmployeeDTO(employee)).toList();
    }

    @Transactional(readOnly = true)
    public List<EmployeeDTO> findEmployeeByName(String name){
        List<Employee> list = employeeRepository.findByNameIgnoreCase(name);
        return list.stream().map(employee -> employeeConverter.toEmployeeDTO(employee)).toList();
    }

    @Transactional
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO){
        emailExists(employeeDTO.getEmail());
        employeeDTO.setPassword(passwordEncoder.encode(employeeDTO.getPassword()));
        Employee employee = employeeConverter.toEmployee(employeeDTO);

        return employeeConverter.toEmployeeDTO(employeeRepository.save(employee));
    }

    @Transactional
    public void deleteEmployee(Long id){
        if (employeeRepository.existsById(id)){
            employeeRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("ID solicitado não existe. Não será possível excluir.");
        }
    }

    public void emailExists(String email){
        try {
            boolean exists = verifyEmail(email);
            if(exists){
                throw new ConflictException("Email ja cadastrado " + email);
            }
        }catch(ConflictException e){
            throw new ConflictException("Email ja cadastrado ", e.getCause());
        }
    }

    public boolean verifyEmail(String email){
        return employeeRepository.existsByEmail(email);
    }

}