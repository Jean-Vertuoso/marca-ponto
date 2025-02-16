package br.com.horadoponto.infraestructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.horadoponto.infraestructure.entities.TimeEntry;

public interface TimeEntryRepository extends JpaRepository<TimeEntry, Long> {
}
