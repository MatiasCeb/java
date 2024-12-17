package com.inmobiliaria.java.service;

import java.util.List;

import com.inmobiliaria.java.dto.LandlordDTO;
import com.inmobiliaria.java.model.Landlord;

public interface ILandlordService {
    public List<LandlordDTO> getLandlords();

    public LandlordDTO saveLandlord(LandlordDTO landlordDTO);

    // TODO: devolucion de un mensaje al cliente cuando se trate de eliminar un Landlord que esta ligado a una clase contrato.
    public void deleteLandlord(Long id);

    public Landlord findLandlord(Long id);

    public void updateLandlordFields(Landlord landlord, LandlordDTO dto);
}
