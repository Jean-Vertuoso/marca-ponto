package br.com.marcaponto.business.dto.in;

public class DepartmentDTORequest {

    private String name;

    public DepartmentDTORequest() {
    }

    public DepartmentDTORequest(Long id, String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}