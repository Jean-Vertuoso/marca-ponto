package br.com.horadoponto.infrastructure.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

import jakarta.persistence.*;

import br.com.horadoponto.infrastructure.entities.enums.EmployeeStatus;

@Entity
@Table(name = "tb_employee")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "email", unique = true, length = 100)
    private String email;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "password")
    private String password;

    @Column(name = "status")
    private EmployeeStatus status;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tb_employee_address",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id"))
    private List<Address> addresses = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private List<Phone> phones = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private List<AbsenceRegistry> absenceRegistries = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private List<TimeEntry> timeEntries = new ArrayList<>();

    public Employee() {
    }

    public Employee(Department department, EmployeeStatus status, String password, LocalDate birthDate, String email, String name, Long id) {
        this.department = department;
        this.status = status;
        this.password = password;
        this.birthDate = birthDate;
        this.email = email;
        this.name = name;
        this.id = id;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public List<AbsenceRegistry> getAbsenceRegistries() {
        return absenceRegistries;
    }

    public List<TimeEntry> getTimeEntries() {
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