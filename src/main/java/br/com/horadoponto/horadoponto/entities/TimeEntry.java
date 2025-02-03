package br.com.horadoponto.horadoponto.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_time_entries")
public class TimeEntry implements Serializable {

    @Id
    private Long id;
    private Instant moment;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public TimeEntry() {
    }

    public TimeEntry(Long id, Instant moment, Employee employee) {
        this.id = id;
        this.moment = moment;
        this.employee = employee;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
