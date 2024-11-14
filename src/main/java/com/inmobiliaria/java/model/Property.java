package com.inmobiliaria.java.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "property_id")
    private Long id;

    @Column(name = "property_name")
    private String name;

    @Column(name = "property_street")
    private String street;

    @Column(name = "property_streetnumber")
    private Long streetNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "locator_id")
    private Locator locator;
    
    public Property() {
    }

    public Property(Long id, String name, String street, Long streetNumber, Locator locator) {
        this.id = id;
        this.name = name;
        this.street = street;
        this.streetNumber = streetNumber;
        this.locator = locator;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public Long getStreetNumber() {
        return streetNumber;
    }

    public Long getLocator() {
        return locator.getId();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setStreetNumber(Long streetNumber) {
        this.streetNumber = streetNumber;
    }

}
