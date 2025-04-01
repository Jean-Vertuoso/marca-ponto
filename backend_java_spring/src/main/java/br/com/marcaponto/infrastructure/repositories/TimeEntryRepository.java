package br.com.marcaponto.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.marcaponto.infrastructure.entities.TimeEntry;

public interface TimeEntryRepository extends JpaRepository<TimeEntry, Long> {
}
