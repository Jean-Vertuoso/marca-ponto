package br.com.horadoponto.infrastructure.repositories;

import br.com.horadoponto.infrastructure.entities.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.horadoponto.infrastructure.entities.Phone;

import java.util.Optional;

public interface PhoneRepository extends JpaRepository<Phone, Long> {

    boolean existsByDddAndNumber(String ddd, String number);

    Optional<Phone> findByDddAndNumber(String ddd, String number);
}
