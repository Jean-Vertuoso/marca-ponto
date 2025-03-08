package br.com.horadoponto.business.services;

import org.springframework.stereotype.Service;

import br.com.horadoponto.business.converters.TimeEntryConverter;
import br.com.horadoponto.business.dto.TimeEntryDTO;
import br.com.horadoponto.infrastructure.entities.TimeEntry;
import br.com.horadoponto.infrastructure.repositories.TimeEntryRepository;

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

    public TimeEntryDTO saveTimeEntry(String token){
        TimeEntry timeEntry = timeEntryConverter.toTimeEntry(employeeService.getAuthenticatedEmployeeId(token));
        TimeEntryDTO timeEntryDTO = timeEntryConverter.toTimeEntryDTO(timeEntryRepository.save(timeEntry));
        emailService.sendEmail(timeEntryDTO, employeeService.getAuthenticatedEmployeeEmail(token));
        return timeEntryDTO;
    }
}
