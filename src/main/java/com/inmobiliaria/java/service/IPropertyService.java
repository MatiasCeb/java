package com.inmobiliaria.java.service;

import java.util.List;

import com.inmobiliaria.java.dto.PropertyDTO;
import com.inmobiliaria.java.model.Property;

public interface IPropertyService {
    public List<PropertyDTO> getProperties();

    public Property getProperty(Long id);

    public PropertyDTO saveProperty(PropertyDTO properDTO);

    // TODO: devolucion de un mensaje al cliente cuando se trate de eliminar un renter que esta ligado a una clase contrato.
    public void deleteProperty(Long id);

    public Property findProperty(Long id);

    public List<Property> findPropertiesByIds(List<Long> propertyIds);

    public void editProperty(Property property, PropertyDTO properDTO);

    List<Property> getPropertiesByPersonId(Long personId);
}
