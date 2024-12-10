package com.inmobiliaria.java.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Renter extends Person{

    @Column(name = "renter_cuil")
    private String cuil;

    @Column(name = "renter_income")
    private double monthlyIncome;

    @Column(name = "renter_employer")
    private String employer;

    public Renter() {
    }

    public Renter(Long id, String name, String lastname, Long dni, String email, String phone,
            List<Property> propertiesList) {
        super(id, name, lastname, dni, email, phone, propertiesList);
    }

    public Renter(Long id, String name, String lastname, Long dni, String email, String phone,
            List<Property> propertiesList, String cuil, double monthlyIncome, String employer) {
        super(id, name, lastname, dni, email, phone, propertiesList);
        this.cuil = cuil;
        this.monthlyIncome = monthlyIncome;
        this.employer = employer;
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

}
