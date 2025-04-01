package br.com.marcaponto.infrastructure.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.marcaponto.infrastructure.entities.Employee;
import br.com.marcaponto.infrastructure.repositories.EmployeeRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private EmployeeRepository employeeRepository;

    public UserDetailsServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Implementação do método para carregar detalhes do usuário pelo e-mail
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Busca o usuário no banco de dados pelo e-mail
        Employee employee = employeeRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("E-mail não encontrado: " + email));

        // Cria e retorna um objeto UserDetails com base no usuário encontrado
        return org.springframework.security.core.userdetails.User
                .withUsername(employee.getEmail()) // Define o nome de usuário como o e-mail
                .password(employee.getPassword()) // Define a senha do usuário
                .build(); // Constrói o objeto UserDetails
    }
}
