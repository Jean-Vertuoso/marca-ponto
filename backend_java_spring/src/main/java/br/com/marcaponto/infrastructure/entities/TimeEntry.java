package br.com.marcaponto.infrastructure.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_time_entry")
public class TimeEntry implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "moment")
    private Instant moment;

    @Column(name = "employee_id")
    private Long employee_id;

    public TimeEntry() {
    }

    public TimeEntry(Long id, Instant moment, Long employee_id) {
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TimeEntry timeEntry = (TimeEntry) o;
        return Objects.equals(id, timeEntry.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
