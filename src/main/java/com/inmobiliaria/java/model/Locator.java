package com.inmobiliaria.java.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Locator {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String lastname;
    // @OneToMany(mappedBy = "locator")
    @OneToMany
    private List<Property> propertiesList;


    public Locator() {
    }


    public Locator(Long id, String name, String lastname, List<Property> propertiesList) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.propertiesList = propertiesList;
    }

}
