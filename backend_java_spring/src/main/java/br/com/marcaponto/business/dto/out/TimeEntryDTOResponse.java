package br.com.marcaponto.business.dto.out;

import java.io.Serializable;
import java.time.Instant;

public class TimeEntryDTOResponse implements Serializable {

    private Long id;
    private Instant moment;
    private Long employee_id;

    public TimeEntryDTOResponse() {
    }

    public TimeEntryDTOResponse(Long id, Instant moment, Long employee_id) {
        this.id = id;
        this.moment = moment;
        this.employee_id = employee_id;
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

    public Long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Long employee_id) {
        this.employee_id = employee_id;
    }
}
