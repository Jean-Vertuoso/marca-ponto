package br.com.horadoponto.controllers.dto;

import br.com.horadoponto.infrastructure.entities.Employee;
import br.com.horadoponto.infrastructure.entities.Phone;

public class PhoneDTO {

    private Long id;
    private String ddd;
    private String number;

    public PhoneDTO() {
    }

    public PhoneDTO(Long id, String ddd, String number) {
        this.id = id;
        this.ddd = ddd;
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
