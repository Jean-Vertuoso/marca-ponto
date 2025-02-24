package br.com.horadoponto.infrastructure.entities;

import java.io.File;
import java.io.Serializable;
import java.time.LocalDateTime;

public class Vacation extends AbsenceRegistry implements Serializable {

    private File signedDocument;

    public Vacation() {
    }

    public Vacation(Long id, String description, LocalDateTime startTime, LocalDateTime endTime, Employee employee, File signedDocument) {
        super(id, description, startTime, endTime, employee);
        this.signedDocument = signedDocument;
    }

    public File getSignedDocument() {
        return signedDocument;
    }

    public void setSignedDocument(File signedDocument) {
        this.signedDocument = signedDocument;
    }
}
