package com.example.dao.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "invoices")
public class Invoice {

    private int id;
    private String no;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = com.example.dao.entity.Company.class)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = com.example.dao.entity.Counterparty.class)
    @JoinColumn(name = "counterparty_id", nullable = false)
    private Counterparty counterparty;

    @Column(name = "bank_account")
    private String bankAccount;

    @OneToMany(targetEntity = com.example.dao.entity.InvoiceEntity.class,
            cascade = CascadeType.ALL, mappedBy = "invoice")
    private List<InvoiceEntity> entities;

    public Invoice() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Counterparty getCounterparty() {
        return counterparty;
    }

    public void setCounterparty(Counterparty counterparty) {
        this.counterparty = counterparty;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public List<InvoiceEntity> getEntities() {
        return entities;
    }

    public void setEntities(List<InvoiceEntity> entities) {
        this.entities = entities;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", no='" + no + '\'' +
                ", company=" + company +
                ", counterparty=" + counterparty +
                ", bankAccount='" + bankAccount + '\'' +
                ", entities=" + entities +
                '}';
    }
}
