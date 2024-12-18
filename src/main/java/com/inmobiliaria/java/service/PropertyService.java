package com.inmobiliaria.java.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inmobiliaria.java.dto.LandlordDTOMapper;
import com.inmobiliaria.java.dto.PropertyDTO;
import com.inmobiliaria.java.dto.PropertyDTOMapper;
import com.inmobiliaria.java.model.Landlord;
import com.inmobiliaria.java.model.Property;
import com.inmobiliaria.java.repository.IPropertyRepository;

@Service
public class PropertyService implements IPropertyService {

    @Autowired
    private IPropertyRepository properRepo;

    @Override
    public List<PropertyDTO> getProperties() {
        List<Property> propertiesList = properRepo.findAll();

        return propertiesList.stream()
            .map(PropertyDTOMapper::toDTO)
            .collect(Collectors.toList());
    }
    
    @Override
    public Property getProperty(Long id) {
        Property proper = properRepo.findById(id).orElse(null);
        return proper;
    }
    
    @Override
    public PropertyDTO saveProperty(PropertyDTO properDTO) {
        //properRepo.save(properDTO);

        Property property = PropertyDTOMapper.toEntity(properDTO);
        property = properRepo.save(property);
        return PropertyDTOMapper.toDTO(property);
    }

    @Override
    public void deleteProperty(Long id) {
        properRepo.deleteById(id);
    }

    @Override
    public Property findProperty(Long id) {
        Property proper = properRepo.findById(id).orElse(null);
        return proper;
    }

    @Override
    public List<Property> findPropertiesByIds(List<Long> propertyIds) {
        return properRepo.findAllById(propertyIds);
    }

    @Override
    public void editProperty(Property property, PropertyDTO dto) {
        if (dto.getName() != null) {
            property.setName(dto.getName());
        }
        if (dto.getStreet() != null) {
            property.setStreet(dto.getStreet());
        }
        if (dto.getStreetNumber() != null) {
            property.setStreetNumber(dto.getStreetNumber());
        }
        if (dto.getPerson() != null) {
            property.setPerson(dto.getPerson());
        }

        properRepo.save(property);
    }

    @Override
    public List<Property> getPropertiesByPersonId(Long personId) {
        return properRepo.findByPersonId(personId);
    }

}
