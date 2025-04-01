package br.com.marcaponto.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.marcaponto.business.dto.out.TimeEntryDTOResponse;
import br.com.marcaponto.business.services.TimeEntryService;

@RestController
@RequestMapping("/timeentry")
public class TimeEntryController {

    private TimeEntryService timeEntryService;

    public TimeEntryController(TimeEntryService timeEntryService) {
        this.timeEntryService = timeEntryService;
    }

    @PostMapping("/save")
    public ResponseEntity<TimeEntryDTOResponse> saveTimeEntry(@RequestHeader("Authorization") String token){
        return ResponseEntity.ok(timeEntryService.saveTimeEntry(token));
    }
}