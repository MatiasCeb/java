package com.inmobiliaria.java.service;

import java.util.List;

import com.inmobiliaria.java.model.Locator;

public interface ILocatorService {
    public List<Locator> getLocators();

    public void saveLocator(Locator loc);

    public void deleteLocator(Long id);

    public Locator findLocator(Long id);

    public void editLocator(Long originalId, long newId, String newName, String newLastname);
}
