package br.com.marcaponto.business.dto.in;

import java.io.Serializable;
import java.time.LocalDateTime;

public class AbsenceRegistryDTORequest implements Serializable {

    private String description;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public AbsenceRegistryDTORequest() {
    }

    public AbsenceRegistryDTORequest(String description, LocalDateTime startTime, LocalDateTime endTime) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
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
