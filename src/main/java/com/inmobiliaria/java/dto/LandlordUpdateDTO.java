package com.inmobiliaria.java.dto;

import java.util.List;

public class LandlordUpdateDTO {
    private Long id;
    private String name;
    private String lastname;
    private Long dni;
    private String email;
    private Long phone;
    private Long cuit;
    private String bank;
    private String bankAccount;

    private List<Long> propertiesListIds;

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

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public Long getCuit() {
        return cuit;
    }

    public void setCuit(Long cuit) {
        this.cuit = cuit;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public List<Long> getPropertiesListIds() {
        return propertiesListIds;
    }

    public void setPropertiesListIds(List<Long> propertiesListIds) {
        this.propertiesListIds = propertiesListIds;
    }
}
