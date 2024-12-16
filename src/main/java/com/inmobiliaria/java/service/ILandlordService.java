package com.inmobiliaria.java.service;

import java.util.List;

import com.inmobiliaria.java.dto.LandlordUpdateDTO;
import com.inmobiliaria.java.model.Landlord;

public interface ILandlordService {
    public List<Landlord> getLandlords();

    public void saveLandlord(Landlord landlord);

    // TODO: devolucion de un mensaje al cliente cuando se trate de eliminar un Landlord que esta ligado a una clase contrato.
    public void deleteLandlord(Long id);

    public Landlord findLandlord(Long id);

    public void editLandlord(Landlord landlord);

    public void updateLandlordFields(Landlord landlord, LandlordUpdateDTO dto);
}
