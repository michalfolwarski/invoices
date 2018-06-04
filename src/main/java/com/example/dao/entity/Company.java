package com.example.dao.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode
@ToString
@Setter
@Getter
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

    public List<Counterparty> getCounterparties() {
        return Counterparties;
    }

    public void setCounterparties(List<Counterparty> counterparties) {
        Counterparties = counterparties;
    }
}
