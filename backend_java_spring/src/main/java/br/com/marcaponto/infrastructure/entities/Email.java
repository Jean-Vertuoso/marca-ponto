package br.com.marcaponto.infrastructure.entities;

import java.time.Instant;

import jakarta.persistence.*;

import br.com.marcaponto.infrastructure.entities.enums.EmailStatus;

@Entity
@Table(name = "tb_email")
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sent_at")
    private Instant sentAT;

    @Column(name = "status")
    private EmailStatus status;

    @Column(name = "time_entry_id")
    private Long timeEntry_id;

    public Email() {
    }

    public Email(Long id, Instant sendAt, EmailStatus status, Long timeEntry_id) {
        this.id = id;
        this.sentAT = sendAt;
        this.status = status;
        this.timeEntry_id = timeEntry_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getSentAT() {
        return sentAT;
    }

    public void setSentAT(Instant sentAT) {
        this.sentAT = sentAT;
    }

    public EmailStatus getStatus() {
        return status;
    }

    public void setStatus(EmailStatus status) {
        this.status = status;
    }

    public Long getTimeEntry_id() {
        return timeEntry_id;
    }

    public void setTimeEntry_id(Long timeEntry_id) {
        this.timeEntry_id = timeEntry_id;
    }
}
