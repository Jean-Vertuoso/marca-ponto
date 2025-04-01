package br.com.marcaponto.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.marcaponto.infrastructure.entities.Email;

public interface EmailRepository extends JpaRepository<Email, Long> {
}
