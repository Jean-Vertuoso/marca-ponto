package br.com.horadoponto.business.converters;

import java.time.Instant;

import org.springframework.stereotype.Component;

import br.com.horadoponto.business.dto.TimeEntryDTO;
import br.com.horadoponto.infrastructure.entities.TimeEntry;

@Component
public class TimeEntryConverter {

    public TimeEntry toTimeEntry(Long employeeId){
        TimeEntry timeEntry = new TimeEntry();
        timeEntry.setMoment(Instant.now());
        timeEntry.setEmployee_id(employeeId);

        return timeEntry;
    }

    public TimeEntryDTO toTimeEntryDTO(TimeEntry timeEntry){
        TimeEntryDTO timeEntryDTO = new TimeEntryDTO();
        timeEntryDTO.setId(timeEntry.getId());
        timeEntryDTO.setMoment(timeEntry.getMoment());
        timeEntryDTO.setEmployee_id(timeEntry.getEmployee_id());

        return timeEntryDTO;
    }
}
