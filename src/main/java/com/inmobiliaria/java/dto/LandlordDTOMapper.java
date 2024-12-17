package com.inmobiliaria.java.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.inmobiliaria.java.model.Landlord;
import com.inmobiliaria.java.model.Property;

public class LandlordDTOMapper {

    public static LandlordDTO toDTO(Landlord landlord) {
        if (landlord == null) {
            return null;
        }

        List<Long> propertyIds = landlord.getPropertiesList() != null
                ? landlord.getPropertiesList().stream().map(Property::getId).collect(Collectors.toList())
                : null;

        return new LandlordDTO(
                landlord.getId(),
                landlord.getName(),
                landlord.getLastname(),
                landlord.getDni(),
                landlord.getEmail(),
                landlord.getPhone(),
                landlord.getCuit(),
                landlord.getBank(),
                landlord.getBankAccount(),
                propertyIds
        );
    }

    public static Landlord toEntity(LandlordDTO dto) {
        if (dto == null) {
            return null;
        }

        Landlord landlord = new Landlord();
        landlord.setId(dto.getId());
        landlord.setName(dto.getName());
        landlord.setLastname(dto.getLastname());
        landlord.setDni(dto.getDni());
        landlord.setEmail(dto.getEmail());
        landlord.setPhone(dto.getPhone());
        landlord.setCuit(dto.getCuit());
        landlord.setBank(dto.getBank());
        landlord.setBankAccount(dto.getBankAccount());

        return landlord;
    }
}

