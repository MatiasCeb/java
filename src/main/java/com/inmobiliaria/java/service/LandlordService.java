package com.inmobiliaria.java.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inmobiliaria.java.dto.LandlordDTO;
import com.inmobiliaria.java.dto.LandlordDTOMapper;
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
    public List<LandlordDTO> getLandlords() {
        List<Landlord> landlordsList = landlordRepo.findAll();

        return landlordsList.stream()
            .map(LandlordDTOMapper::toDTO)
            .collect(Collectors.toList());
    }

    @Override
    public LandlordDTO saveLandlord(LandlordDTO landlordDTO) {
        // landlordRepo.save(landlord);

        Landlord landlord = LandlordDTOMapper.toEntity(landlordDTO);
        landlord = landlordRepo.save(landlord);
        return LandlordDTOMapper.toDTO(landlord);
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

    public void updateLandlordFields(Landlord landlord, LandlordDTO dto) {
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
    
        landlordRepo.save(landlord);
    }
}
