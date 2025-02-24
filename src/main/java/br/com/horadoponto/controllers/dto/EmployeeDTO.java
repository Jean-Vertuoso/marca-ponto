package br.com.horadoponto.controllers.dto;

import br.com.horadoponto.infrastructure.entities.Department;
import br.com.horadoponto.infrastructure.entities.enums.EmployeeStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDTO {

    private Long id;
    private String name;
    private String email;
    private LocalDate birthDate;
    private String password;
    private EmployeeStatus status;
    private DepartmentDTO department;

    private List<AddressDTO> addresses = new ArrayList<>();
    private List<PhoneDTO> phones = new ArrayList<>();
    private List<AbsenceRegistryDTO> absenceRegistries = new ArrayList<>();
    private List<TimeEntryDTO> timeEntries = new ArrayList<>();

    public EmployeeDTO() {
    }

    public EmployeeDTO(Long id, String name, String email, LocalDate birthDate, String password, EmployeeStatus status, DepartmentDTO department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.password = password;
        this.status = status;
        this.department = department;
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

    public DepartmentDTO getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentDTO department) {
        this.department = department;
    }

    public List<AddressDTO> getAddresses() {
        return addresses;
    }

    public List<PhoneDTO> getPhones() {
        return phones;
    }

    public List<AbsenceRegistryDTO> getAbsenceRegistries() {
        return absenceRegistries;
    }

    public List<TimeEntryDTO> getTimeEntries() {
        return timeEntries;
    }
}
