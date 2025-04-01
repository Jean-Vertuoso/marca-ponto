package br.com.marcaponto.business.dto.out;

public class PhoneDTOResponse {

    private Long id;
    private String ddd;
    private String number;

    public PhoneDTOResponse() {
    }

    public PhoneDTOResponse(Long id, String ddd, String number) {
        this.id = id;
        this.ddd = ddd;
        this.number = number;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
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
