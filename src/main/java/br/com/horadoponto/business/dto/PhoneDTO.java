package br.com.horadoponto.business.dto;

public class PhoneDTO {

    private String ddd;
    private String number;

    public PhoneDTO() {
    }

    public PhoneDTO(String ddd, String number) {
        this.ddd = ddd;
        this.number = number;
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
