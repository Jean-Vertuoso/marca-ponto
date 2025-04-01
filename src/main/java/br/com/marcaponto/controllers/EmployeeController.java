package br.com.marcaponto.controllers;

import java.util.List;

import br.com.marcaponto.business.dto.in.LoginRequestDTO;
import br.com.marcaponto.business.dto.out.EmployeeDTOResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import br.com.marcaponto.business.services.EmployeeService;
import br.com.marcaponto.business.dto.in.EmployeeDTORequest;
import br.com.marcaponto.infrastructure.security.JwtUtil;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public EmployeeController(EmployeeService employeeService, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.employeeService = employeeService;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequestDTO loginRequestDTO){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDTO.getEmail(),
                        loginRequestDTO.getPassword())
        );
        return "Bearer " + jwtUtil.generateToken(authentication.getName());
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDTOResponse>> findAllEmployees(){
        List<EmployeeDTOResponse> list = employeeService.findAllEmployees();
        return ResponseEntity.ok(list);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTOResponse>> findEmployeeByName(@RequestParam() String name){
        List<EmployeeDTOResponse> list = employeeService.findEmployeeByName(name);
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<EmployeeDTOResponse> saveEmployee(@RequestBody EmployeeDTORequest employeeDTO){
        return ResponseEntity.ok(employeeService.saveEmployee(employeeDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
