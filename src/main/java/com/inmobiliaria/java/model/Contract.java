package com.inmobiliaria.java.model;

import jakarta.persistence.*;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "locator_id", nullable = false)
    private Locator locator;

    @ManyToOne
    @JoinColumn(name = "renter_id", nullable = false)
    private Renter renter;

    @ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
    private Property property;

    // Otros campos adicionales (fechas, monto, etc.)
    // private String startDate;
    // private String endDate;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Locator getLocator() { return locator; }
    public void setLocator(Locator locator) { this.locator = locator; }

    public Renter getRenter() { return renter; }
    public void setRenter(Renter renter) { this.renter = renter; }

    public Property getProperty() { return property; }
    public void setProperty(Property property) { this.property = property; }
}
