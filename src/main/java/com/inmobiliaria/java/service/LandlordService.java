package com.inmobiliaria.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inmobiliaria.java.dto.LandlordUpdateDTO;
import com.inmobiliaria.java.model.Landlord;
import com.inmobiliaria.java.model.Property;
import com.inmobiliaria.java.repository.ILandlordRepository;

@Service
public class LandlordService implements ILandlordService {

    @Autowired
    private ILandlordRepository landlordRepo;

    @Autowired
    private PropertyService propertyService;


    @Override
    public List<Landlord> getLandlords() {
        List<Landlord> landlordsList = landlordRepo.findAll();
        return landlordsList;
    }

    @Override
    public void saveLandlord(Landlord landlord) {
        landlordRepo.save(landlord);
    }

    @Override
    public void deleteLandlord(Long id) {
        landlordRepo.deleteById(id);
    }

    @Override
    public Landlord findLandlord(Long id) {
        Landlord landlord = landlordRepo.findById(id).orElse(null);
        return landlord;
    }

    @Override
    public void editLandlord(Landlord landlord) {
        this.saveLandlord(landlord);
    }

    public void updateLandlordFields(Landlord landlord, LandlordUpdateDTO dto) {
    if (dto.getName() != null) {
        landlord.setName(dto.getName());
    }
    if (dto.getLastname() != null) {
        landlord.setLastname(dto.getLastname());
    }
    if (dto.getDni() != null) {
        landlord.setDni(dto.getDni());
    }
    if (dto.getEmail() != null) {
        landlord.setEmail(dto.getEmail());
    }
    if (dto.getPhone() != null) {
        landlord.setPhone(dto.getPhone());
    }
    if (dto.getCuit() != null) {
        landlord.setCuit(dto.getCuit());
    }
    if (dto.getBank() != null) {
        landlord.setBank(dto.getBank());
    }
    if (dto.getBankAccount() != null) {
        landlord.setBankAccount(dto.getBankAccount());
    }

    if (dto.getPropertiesListIds() != null) {
        List<Property> properties = propertyService.findPropertiesByIds(dto.getPropertiesListIds());
        landlord.setPropertiesList(properties);
    }

    this.saveLandlord(landlord);
}
}
