package br.com.horadoponto.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.horadoponto.infrastructure.entities.TimeEntry;

public interface TimeEntryRepository extends JpaRepository<TimeEntry, Long> {
}
