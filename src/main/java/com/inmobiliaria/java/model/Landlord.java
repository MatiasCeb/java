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
public class Landlord extends Person {

    @Column(name = "landlord_cuit")
    private Long cuit; 

    @Column(name = "landlord_bank")
    private String bank; 

    @Column(name = "landlord_accountNumber")
    private String bankAccount; 


    public Landlord() {
    }


    public Landlord(Long cuit, String bank, String bankAccount) {
        this.cuit = cuit;
        this.bank = bank;
        this.bankAccount = bankAccount;
    }


    public Landlord(Long id, String name, String lastname, Long dni, String email, Long phone,
            List<Property> propertiesList, Long cuit, String bank, String bankAccount) {
        super(id, name, lastname, dni, email, phone, propertiesList);
        this.cuit = cuit;
        this.bank = bank;
        this.bankAccount = bankAccount;
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


    
}
