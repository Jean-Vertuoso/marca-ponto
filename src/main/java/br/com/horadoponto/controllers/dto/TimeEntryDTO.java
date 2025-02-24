package br.com.horadoponto.controllers.dto;

import java.io.Serializable;
import java.time.Instant;

public class TimeEntryDTO implements Serializable {

    private Long id;
    private Instant moment;

    public TimeEntryDTO() {
    }

    public TimeEntryDTO(Long id, Instant moment) {
        this.id = id;
        this.moment = moment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }
}
