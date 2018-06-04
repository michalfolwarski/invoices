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
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}
