package com.inmobiliaria.java.model;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "person_id")
    private Long id;
    @Column(name = "person_name")
    private String name;
    @Column(name = "person_lastname")
    private String lastname;
    @Column(name = "person_dni")
    private Long dni;
    @Column(name = "person_email")
    private String email;
    @Column(name = "person_phone")
    private String phone;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<Property> propertiesList;


    public Person() {
    }

    public Person(Long id, String name, String lastname, Long dni, String email, String phone,
            List<Property> propertiesList) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.dni = dni;
        this.email = email;
        this.phone = phone;
        this.propertiesList = propertiesList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Property> getPropertiesList() {
        return propertiesList;
    }

    public void setPropertiesList(List<Property> propertiesList) {
        this.propertiesList = propertiesList;
    }


}
