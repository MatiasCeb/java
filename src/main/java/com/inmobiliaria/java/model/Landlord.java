package com.inmobiliaria.java.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Landlord {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "landlord_id")
    private Long id;
    @Column(name = "landlord_name")
    private String name;
    @Column(name = "landlord_lastname")
    private String lastname;
    @OneToMany(mappedBy = "landlord", cascade = CascadeType.ALL)
    private List<Property> propertiesList;


    public Landlord() {
    }


    public Landlord(Long id, String name, String lastname, List<Property> propertiesList) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.propertiesList = propertiesList;
    }


    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public String getLastname() {
        return lastname;
    }


    public List<Property> getPropertiesList() {
        return propertiesList;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    public void setPropertiesList(List<Property> propertiesList) {
        this.propertiesList = propertiesList;
    }

}
