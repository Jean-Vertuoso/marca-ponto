package br.com.marcaponto.business.dto.in;

public class PhoneDTORequest {

    private String ddd;
    private String number;

    public PhoneDTORequest() {
    }

    public PhoneDTORequest(String ddd, String number) {
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
