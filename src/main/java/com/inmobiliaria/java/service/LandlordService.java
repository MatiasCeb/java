package com.inmobiliaria.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inmobiliaria.java.model.Landlord;
import com.inmobiliaria.java.repository.ILandlordRepository;

@Service
public class LandlordService implements ILandlordService {

    @Autowired
    private ILandlordRepository landlordRepo;


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
    public void editLandlord(Long originalId, long newId, String newName, String newLastname) {
        Landlord landlord = this.findLandlord(originalId);
        landlord.setId(newId);
        landlord.setLastname(newLastname);
        landlord.setName(newName);


        this.saveLandlord(landlord);
    }

    @Override
    public void editLandlord(Landlord landlord) {
        this.saveLandlord(landlord);
    }
}
