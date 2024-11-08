package com.inmobiliaria.java.service;

import java.util.List;

import com.inmobiliaria.java.model.Property;

public interface IPropertyService {
    public List<Property> getProperties();

    public void saveProperty(Property proper);

    public void deleteProperty(Long id);

    public Property findProperty(Long id);

    public void editProperty(Property proper);
}
