package br.com.marcaponto.business.dto.out;

import br.com.marcaponto.infrastructure.entities.enums.EmployeeStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDTOResponse {

    private Long id;
    private String name;
    private String email;
    private LocalDate birthDate;
    private String password;
    private EmployeeStatus status;
    private Long department_id;

    private List<AddressDTOResponse> addresses = new ArrayList<>();
    private List<PhoneDTOResponse> phones = new ArrayList<>();
    private List<AbsenceRegistryDTOResponse> absenceRegistries = new ArrayList<>();
    private List<TimeEntryDTOResponse> timeEntries = new ArrayList<>();

    public EmployeeDTOResponse() {
    }

    public EmployeeDTOResponse(Long id, String name, String email, LocalDate birthDate, String password, EmployeeStatus status, Long department_id) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.password = password;
        this.status = status;
        this.department_id = department_id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    public Long getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Long department_id) {
        this.department_id = department_id;
    }

    public List<AddressDTOResponse> getAddresses() {
        return addresses;
    }

    public List<PhoneDTOResponse> getPhones() {
        return phones;
    }

    public List<AbsenceRegistryDTOResponse> getAbsenceRegistries() {
        return absenceRegistries;
    }

    public List<TimeEntryDTOResponse> getTimeEntries() {
        return timeEntries;
    }
}
