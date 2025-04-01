package br.com.marcaponto.infrastructure.repositories;

import br.com.marcaponto.infrastructure.entities.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PhoneRepository extends JpaRepository<Phone, Long> {

    boolean existsByDddAndNumber(String ddd, String number);

    Optional<Phone> findByDddAndNumber(String ddd, String number);
}
