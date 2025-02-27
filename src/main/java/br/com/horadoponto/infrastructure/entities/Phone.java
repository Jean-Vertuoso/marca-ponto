package br.com.horadoponto.infrastructure.entities;

import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_phone")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ddd")
    private String ddd;

    @Column(name = "number")
    private String number;

    @Column(name = "employee_id")
    private Long employee_id;

    public Phone() {
    }

    public Phone(Long id, String ddd, String number, Long employee_id) {
        this.id = id;
        this.ddd = ddd;
        this.number = number;
        this.employee_id = employee_id;
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

    public Long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Long employee_id) {
        this.employee_id = employee_id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return Objects.equals(id, phone.id) && Objects.equals(number, phone.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number);
    }
}
