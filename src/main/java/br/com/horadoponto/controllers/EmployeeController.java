package br.com.horadoponto.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import br.com.horadoponto.business.services.EmployeeService;
import br.com.horadoponto.controllers.dto.EmployeeDTO;
import br.com.horadoponto.infrastructure.security.JwtUtil;

import java.util.List;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    private EmployeeService employeeService;
    private AuthenticationManager authenticationManager;
    private JwtUtil jwtUtil;

    public EmployeeController(EmployeeService employeeService, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.employeeService = employeeService;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public String login(@RequestBody EmployeeDTO employeeDTO){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(employeeDTO.getEmail(), employeeDTO.getPassword())
        );

        return "Bearer " + jwtUtil.generateToken(authentication.getName());
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> findAllEmployees(){
        List<EmployeeDTO> list = employeeService.findAllEmployees();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> saveUser(@RequestBody EmployeeDTO employeeDTO){
        return ResponseEntity.ok(employeeService.saveUser(employeeDTO));
    }
}
