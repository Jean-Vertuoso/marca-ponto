package br.com.marcaponto.business.dto.out;

import java.io.Serializable;
import java.time.LocalDateTime;

public class AbsenceRegistryDTOResponse implements Serializable {

    private Long id;
    private String description;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public AbsenceRegistryDTOResponse() {
    }

    public AbsenceRegistryDTOResponse(Long id, String description, LocalDateTime startTime, LocalDateTime endTime) {
        this.id = id;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
