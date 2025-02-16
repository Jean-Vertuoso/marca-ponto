package br.com.horadoponto.horadoponto.infraestructure.entities;

import java.io.File;
import java.io.Serializable;
import java.time.LocalDateTime;

public class SickLeave extends AbsenceRegistry implements Serializable {

    private File doctorsNote;

    public SickLeave() {
    }

    public SickLeave(Long id, String description, LocalDateTime startTime, LocalDateTime endTime, Employee employee, File doctorsNote) {
        super(id, description, startTime, endTime, employee);
        this.doctorsNote = doctorsNote;
    }

    public File getDoctorsNote() {
        return doctorsNote;
    }

    public void setDoctorsNote(File doctorsNote) {
        this.doctorsNote = doctorsNote;
    }
}
