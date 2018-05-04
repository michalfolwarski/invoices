package com.example.dao.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Embedded
    private Address address;
    private String nip;

    @ManyToMany
    @JoinTable(name = "invoices",
            joinColumns =  @JoinColumn(name="company_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="counterparty_id", referencedColumnName = "id"))
    private List<Counterparty> Counterparties;

    public Company() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public List<Counterparty> getCounterparties() {
        return Counterparties;
    }

    public void setCounterparties(List<Counterparty> counterparties) {
        Counterparties = counterparties;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", nip='" + nip + '\'' +
                ", Counterparties=" + Counterparties +
                '}';
    }
}
