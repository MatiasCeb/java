package com.inmobiliaria.java.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String street;
    private Long streetNumber;

    public Property() {
    }

    public Property(Long id, String name, String street, Long streetNumber) {
        this.id = id;
        this.name = name;
        this.street = street;
        this.streetNumber = streetNumber;
    }

}
