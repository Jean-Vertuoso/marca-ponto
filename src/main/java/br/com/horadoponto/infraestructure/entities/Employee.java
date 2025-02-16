package br.com.horadoponto.horadoponto.infraestructure.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

import jakarta.persistence.*;

import br.com.horadoponto.horadoponto.infraestructure.entities.enums.EmployeeStatus;

@Entity
@Table(name = "tb_employee")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private LocalDate birthDate;
    private String password;
    @Enumerated(EnumType.STRING)
    private EmployeeStatus status;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToMany
    @JoinTable(name = "tb_employee_address",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id"))
    private Set<Address> addresses = new HashSet<>();

    @OneToMany(mappedBy = "employee")
    private Set<Phone> phones = new HashSet<>();

    @OneToMany(mappedBy = "employee")
    private Set<AbsenceRegistry> absenceRegistries = new HashSet<>();

    @OneToMany(mappedBy = "employee")
    private Set<TimeEntry> timeEntries = new HashSet<>();

    public Employee() {
    }

    public Employee(Long id, String name, String email, LocalDate birthDate, String password, Department department, EmployeeStatus status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.password = password;
        this.department = department;
        this.status = status;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public Set<Phone> getPhones() {
        return phones;
    }

    public Set<AbsenceRegistry> getAbsenceRegistries() {
        return absenceRegistries;
    }

    public Set<TimeEntry> getTimeEntries() {
        return timeEntries;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}