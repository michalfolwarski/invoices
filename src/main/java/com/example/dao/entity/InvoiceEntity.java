package com.example.dao.entity;

import javax.persistence.*;

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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getVat() {
        return vat;
    }

    public void setVat(int vat) {
        this.vat = vat;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    @Override
    public String toString() {
        return "InvoiceEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", vat=" + vat +
                ", invoice=" + invoice +
                '}';
    }
}
