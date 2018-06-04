package com.example.dao.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@EqualsAndHashCode
@ToString
@Setter
@Getter
@Entity
@Table(name = "invoices_entities")
public class InvoiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String unit;

    private int quantity;

    @Column(name = "unit_price")
    private double unitPrice;

    private int vat;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = com.example.dao.entity.Invoice.class)
    @JoinColumn(name = "invoice_id", nullable = false)
    private Invoice invoice;

    public InvoiceEntity() {
    }
}
