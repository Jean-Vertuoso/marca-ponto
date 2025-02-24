package br.com.horadoponto.business.services;

import java.util.List;
import java.util.stream.Collectors;

import br.com.horadoponto.infrastructure.exceptions.ConflictException;
import br.com.horadoponto.infrastructure.exceptions.ResourceNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.horadoponto.business.converters.EmployeeConverter;
import br.com.horadoponto.controllers.dto.EmployeeDTO;
import br.com.horadoponto.infrastructure.entities.Employee;
import br.com.horadoponto.infrastructure.repositories.EmployeeRepository;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;
    private EmployeeConverter employeeConverter;
    private PasswordEncoder passwordEncoder;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeConverter employeeConverter, PasswordEncoder passwordEncoder) {
        this.employeeRepository = employeeRepository;
        this.employeeConverter = employeeConverter;
        this.passwordEncoder = passwordEncoder;
    }

    // Método para buscar todos os usuários registrados
    @Transactional(readOnly = true)
    public List<EmployeeDTO> findAllEmployees(){
        List<Employee> list = employeeRepository.findAll();
        return list.stream().map(x -> employeeConverter.toEmployeeDTO(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public EmployeeDTO findUserByEmail(String email){
        try {
            return employeeConverter.toEmployeeDTO(
                        employeeRepository.findByEmail(email)
                            .orElseThrow(() -> new ResourceNotFoundException("E-mail não encontrado " + email)));
        } catch (ResourceNotFoundException e){
            throw new ResourceNotFoundException("E-mail não encontrado " + email);
        }
    }

    @Transactional
    public EmployeeDTO saveUser(EmployeeDTO employeeDTO){
        emailExists(employeeDTO.getEmail());
        employeeDTO.setPassword(passwordEncoder.encode(employeeDTO.getPassword()));
        Employee employee = employeeConverter.toEmployee(employeeDTO);
        return employeeConverter.toEmployeeDTO(
                employeeRepository.save(employee)
        );

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