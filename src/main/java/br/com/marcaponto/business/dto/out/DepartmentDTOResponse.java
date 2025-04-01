package br.com.marcaponto.business.dto.out;

public class DepartmentDTOResponse {

    private Long id;
    private String name;

    public DepartmentDTOResponse() {
    }

    public DepartmentDTOResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}