package com.inmobiliaria.java.model;

import java.time.LocalDate;

public class ContractRequest {

    private Long locatorId;
    private Long renterId;
    private Long propertyId;

    // Getters y setters
    public Long getLocatorId() {
        return locatorId;
    }

    public void setLocatorId(Long locatorId) {
        this.locatorId = locatorId;
    }

    public Long getRenterId() {
        return renterId;
    }

    public void setRenterId(Long renterId) {
        this.renterId = renterId;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }
}
