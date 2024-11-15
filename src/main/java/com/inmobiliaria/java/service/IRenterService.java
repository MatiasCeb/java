package com.inmobiliaria.java.service;

import com.inmobiliaria.java.model.Renter;
import java.util.List;

public interface IRenterService {
    Renter createRenter(Renter renter);
    Renter updateRenter(Long id, Renter renter);
    void deleteRenter(Long id);
    List<Renter> getAllRenters();
    Renter getRenterById(Long id);
}
