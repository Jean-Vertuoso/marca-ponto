package br.com.horadoponto.horadoponto.infraestructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.horadoponto.horadoponto.infraestructure.entities.TimeEntry;

public interface TimeEntryRepository extends JpaRepository<TimeEntry, Long> {
}
