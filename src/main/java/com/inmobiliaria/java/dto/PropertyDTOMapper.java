package com.inmobiliaria.java.dto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.inmobiliaria.java.model.Property;

public class PropertyDTOMapper implements Serializable{

    public static PropertyDTO toDTO(Property property) {
        if (property == null) {
            return null;
        }

        return new PropertyDTO(
                property.getId(),
                property.getName(),
                property.getStreet(),
                property.getStreetNumber(),
                property.getPerson()
        );
    }

    public static Property toEntity(PropertyDTO dto) {
        if (dto == null) {
            return null;
        }

        Property property = new Property();

        property.setId(dto.getId());
        property.setName(dto.getName());
        property.setStreet(dto.getStreet());
        property.setStreetNumber(dto.getStreetNumber());
        property.setPerson(dto.getPerson());

        return property;
    }
}
