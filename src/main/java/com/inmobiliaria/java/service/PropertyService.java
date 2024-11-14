package com.inmobiliaria.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inmobiliaria.java.model.Property;
import com.inmobiliaria.java.repository.IPropertyRepository;

@Service
public class PropertyService implements IPropertyService {

    @Autowired
    private IPropertyRepository properRepo;

    @Override
    public List<Property> getProperties() {
        List<Property> propertiesList = properRepo.findAll();
        return propertiesList;
    }
    
    @Override
    public Property getProperty(Long id) {
        Property proper = properRepo.findById(id).orElse(null);
        return proper;
    }
    
    @Override
    public void saveProperty(Property proper) {
        properRepo.save(proper);
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
    public void editProperty(Property proper) {
        this.saveProperty(proper);
    }
}
