package com.inmobiliaria.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inmobiliaria.java.model.Locator;
import com.inmobiliaria.java.repository.ILocatorRepository;

@Service
public class LocatorService implements ILocatorService {

    @Autowired
    private ILocatorRepository locatorRepo;


    @Override
    public List<Locator> getLocators() {
        List<Locator> locatorsList = locatorRepo.findAll();
        return locatorsList;
    }

    @Override
    public void saveLocator(Locator loc) {
        locatorRepo.save(loc);
    }

    @Override
    public void deleteLocator(Long id) {
        locatorRepo.deleteById(id);
    }

    @Override
    public Locator findLocator(Long id) {
        Locator loc = locatorRepo.findById(id).orElse(null);
        return loc;
    }

    @Override
    public void editLocator(Long originalId, long newId, String newName, String newLastname) {
        Locator loc = this.findLocator(originalId);
        loc.setId(newId);
        loc.setLastname(newLastname);
        loc.setName(newName);


        this.saveLocator(loc);
    }

    @Override
    public void editLocator(Locator loc) {
        this.saveLocator(loc);
    }
}
