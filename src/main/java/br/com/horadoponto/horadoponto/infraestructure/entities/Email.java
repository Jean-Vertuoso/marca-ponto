package br.com.horadoponto.horadoponto.infraestructure.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_email")
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    @OneToOne
    @MapsId
    private TimeEntry timeEntry;

    public Email() {
    }

    public Email(Long id, String title, String description, TimeEntry timeEntry) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.timeEntry = timeEntry;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TimeEntry getTimeEntry() {
        return timeEntry;
    }

    public void setTimeEntry(TimeEntry timeEntry) {
        this.timeEntry = timeEntry;
    }
}
