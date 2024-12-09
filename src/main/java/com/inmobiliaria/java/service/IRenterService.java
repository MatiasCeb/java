package com.inmobiliaria.java.service;

import com.inmobiliaria.java.model.Renter;
import java.util.List;

public interface IRenterService {
    Renter createRenter(Renter renter);

    Renter updateRenter(Long id, Renter renter);

    // TODO: devolucion de un mensaje al cliente cuando se trate de eliminar un renter que esta ligado a una clase contrato.
    void deleteRenter(Long id);

    List<Renter> getAllRenters();
    
    Renter getRenterById(Long id);
}
