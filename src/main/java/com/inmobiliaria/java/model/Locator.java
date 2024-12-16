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
public class Locator extends Person{


    @Column(name = "locator_cuil")
    private String cuil;

    @Column(name = "locator_income")
    private double monthlyIncome;

    @Column(name = "locator_employer")
    private String employer;

    public Locator(Long id, String name, String lastname, Long dni, String email, Long phone,
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
