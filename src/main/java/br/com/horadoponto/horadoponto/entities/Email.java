package br.com.horadoponto.horadoponto.entities;

public class Email {

    private Long id;
    private String title;

    private TimeEntry timeEntry;

    public Email() {
    }

    public Email(Long id, String title, TimeEntry timeEntry) {
        this.id = id;
        this.title = title;
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

    public TimeEntry getTimeEntry() {
        return timeEntry;
    }

    public void setTimeEntry(TimeEntry timeEntry) {
        this.timeEntry = timeEntry;
    }
}
