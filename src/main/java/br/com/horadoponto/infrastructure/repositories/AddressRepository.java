package br.com.horadoponto.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.horadoponto.infrastructure.entities.Address;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {

    boolean existsByStreetAndNeighborhood(String street, String neighborhood);

    Optional<Address> findByStreetAndNeighborhood(String street, String neighborhood);
}
