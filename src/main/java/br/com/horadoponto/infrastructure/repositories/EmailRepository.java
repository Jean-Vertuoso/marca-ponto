package br.com.horadoponto.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.horadoponto.infrastructure.entities.Email;

public interface EmailRepository extends JpaRepository<Email, Long> {
}
