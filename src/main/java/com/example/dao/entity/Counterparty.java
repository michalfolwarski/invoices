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
@Table(name = "counterparites")
public class Counterparty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Embedded
    private Address address;

    private String nip;

    public Counterparty() {
    }
}
