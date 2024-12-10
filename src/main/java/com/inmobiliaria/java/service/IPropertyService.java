package com.inmobiliaria.java.service;

import java.util.List;

import com.inmobiliaria.java.model.Property;

public interface IPropertyService {
    public List<Property> getProperties();

    public Property getProperty(Long id);

    public void saveProperty(Property proper);

    // TODO: devolucion de un mensaje al cliente cuando se trate de eliminar un renter que esta ligado a una clase contrato.
    public void deleteProperty(Long id);

    public Property findProperty(Long id);

    public void editProperty(Property proper);

    List<Property> getPropertiesByPersonId(Long personId);
}
