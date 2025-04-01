package br.com.marcaponto.business.converters;

import br.com.marcaponto.business.dto.out.TimeEntryDTOResponse;
import br.com.marcaponto.infrastructure.entities.TimeEntry;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class TimeEntryConverter {

    public TimeEntry toTimeEntry(Long employeeId){
        TimeEntry timeEntry = new TimeEntry();
        timeEntry.setMoment(Instant.now());
        timeEntry.setEmployee_id(employeeId);

        return timeEntry;
    }

    public TimeEntryDTOResponse toTimeEntryDTO(TimeEntry timeEntry){
        TimeEntryDTOResponse timeEntryDTO = new TimeEntryDTOResponse();
        timeEntryDTO.setId(timeEntry.getId());
        timeEntryDTO.setMoment(timeEntry.getMoment());
        timeEntryDTO.setEmployee_id(timeEntry.getEmployee_id());

        return timeEntryDTO;
    }
}
