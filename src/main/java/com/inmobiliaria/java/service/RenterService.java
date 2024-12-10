package com.inmobiliaria.java.service;

import com.inmobiliaria.java.model.Renter;
import com.inmobiliaria.java.repository.IRenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RenterService implements IRenterService {

    @Autowired
    private IRenterRepository renterRepository;

    @Override
    public Renter createRenter(Renter renter) {
        if (renterRepository.existsByDni(renter.getDni())) {
            throw new RuntimeException("DNI ya registrado");
        }
        return renterRepository.save(renter);
    }

    @Override
    public Renter updateRenter(Long id, Renter renter) {
        Renter existingRenter = renterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inquilino no encontrado"));

        existingRenter.setName(renter.getName());
        existingRenter.setLastname(renter.getLastname());
        existingRenter.setDni(renter.getDni());

        return renterRepository.save(existingRenter);
    }

    @Override
    public void deleteRenter(Long id) {
        renterRepository.deleteById(id);
    }

    @Override
    public List<Renter> getAllRenters() {
        return renterRepository.findAll();
    }

    @Override
    public Renter getRenterById(Long id) {
        return renterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Renter no encontrado"));
    }
}
