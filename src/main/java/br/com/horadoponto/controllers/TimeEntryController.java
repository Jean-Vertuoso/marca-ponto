package br.com.horadoponto.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.horadoponto.business.dto.TimeEntryDTO;
import br.com.horadoponto.business.services.TimeEntryService;

@RestController
@RequestMapping("/timeentry")
public class TimeEntryController {

    private TimeEntryService timeEntryService;

    public TimeEntryController(TimeEntryService timeEntryService) {
        this.timeEntryService = timeEntryService;
    }

    @PostMapping("/save")
    public ResponseEntity<TimeEntryDTO> saveTimeEntry(@RequestHeader("Authorization") String token){
        return ResponseEntity.ok(timeEntryService.saveTimeEntry(token));
    }
}
