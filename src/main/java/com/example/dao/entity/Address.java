package com.example.dao.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@EqualsAndHashCode
@ToString
@Setter
@Getter
@Embeddable
public class Address {
    private String street;

    @Column(name = "zip_code")
    private String zipCode;

    private String city;

    public Address() {
    }
}
