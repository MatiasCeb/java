package com.inmobiliaria.java.dto;

import java.io.Serializable;

import com.inmobiliaria.java.model.Person;

public class PropertyDTO implements Serializable{

    private Long id;
    private String name;
    private String street;
    private Long streetNumber;
    // TODO: Devolver solamente el id.
    private Person person;
    
    public PropertyDTO() {
    }

    public PropertyDTO(Long id, String name, String street, Long streetNumber, Person person) {
        this.id = id;
        this.name = name;
        this.street = street;
        this.streetNumber = streetNumber;
        this.person = person;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Long getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Long streetNumber) {
        this.streetNumber = streetNumber;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    

}
