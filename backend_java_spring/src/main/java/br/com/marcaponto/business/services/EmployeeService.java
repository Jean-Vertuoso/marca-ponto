package br.com.marcaponto.business.services;

import br.com.marcaponto.business.converters.EmployeeConverter;
import br.com.marcaponto.business.dto.in.EmployeeDTORequest;
import br.com.marcaponto.business.dto.out.EmployeeDTOResponse;
import br.com.marcaponto.infrastructure.entities.Employee;
import br.com.marcaponto.infrastructure.exceptions.ConflictException;
import br.com.marcaponto.infrastructure.exceptions.ResourceNotFoundException;
import br.com.marcaponto.infrastructure.repositories.EmployeeRepository;
import br.com.marcaponto.infrastructure.security.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeConverter employeeConverter;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeConverter employeeConverter, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.employeeRepository = employeeRepository;
        this.employeeConverter = employeeConverter;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @Transactional(readOnly = true)
    public List<EmployeeDTOResponse> findAllEmployees(){
        List<Employee> list = employeeRepository.findAll();
        return list.stream().map(employeeConverter::toEmployeeDTO).toList();
    }

    @Transactional(readOnly = true)
    public List<EmployeeDTOResponse> findEmployeeByName(String name){
        List<Employee> list = employeeRepository.findByNameIgnoreCase(name);
        return list.stream().map(employeeConverter::toEmployeeDTO).toList();
    }

    @Transactional(readOnly = true)
    public EmployeeDTOResponse findEmployeeById(Long id){
        Employee employee = employeeRepository.findById(id)
                                .orElseThrow(() -> new ResourceNotFoundException("Id não encontrado."));
        return employeeConverter.toEmployeeDTO(employee);
    }

    @Transactional
    public EmployeeDTOResponse saveEmployee(EmployeeDTORequest employeeDTO){
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

    @Transactional(readOnly = true)
    public Long getAuthenticatedEmployeeId(String token){
        String email = jwtUtil.extrairEmailToken(token.substring(7));
        Employee employee = employeeRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
        return employee.getId();
    }

    @Transactional(readOnly = true)
    public String getAuthenticatedEmployeeEmail(String token){
        return jwtUtil.extrairEmailToken(token.substring(7));
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