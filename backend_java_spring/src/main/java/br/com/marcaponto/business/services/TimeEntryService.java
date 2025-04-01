package br.com.marcaponto.business.services;

import br.com.marcaponto.business.converters.TimeEntryConverter;
import br.com.marcaponto.business.dto.out.TimeEntryDTOResponse;
import br.com.marcaponto.infrastructure.entities.TimeEntry;
import br.com.marcaponto.infrastructure.repositories.TimeEntryRepository;
import org.springframework.stereotype.Service;

@Service
public class TimeEntryService {

    private final TimeEntryRepository timeEntryRepository;
    private final EmployeeService employeeService;
    private final EmailService emailService;
    private final TimeEntryConverter timeEntryConverter;

    public TimeEntryService(TimeEntryRepository timeEntryRepository, EmployeeService employeeService, EmailService emailService, TimeEntryConverter timeEntryConverter) {
        this.timeEntryRepository = timeEntryRepository;
        this.employeeService = employeeService;
        this.emailService = emailService;
        this.timeEntryConverter = timeEntryConverter;
    }

    public TimeEntryDTOResponse saveTimeEntry(String token){
        TimeEntry timeEntry = timeEntryConverter.toTimeEntry(employeeService.getAuthenticatedEmployeeId(token));
        TimeEntryDTOResponse timeEntryDTOReponse = timeEntryConverter.toTimeEntryDTO(timeEntryRepository.save(timeEntry));
        emailService.sendEmail(timeEntryDTOReponse, employeeService.getAuthenticatedEmployeeEmail(token));

        return timeEntryDTOReponse;
    }
}
