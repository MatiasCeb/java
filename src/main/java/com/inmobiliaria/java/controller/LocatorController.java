package com.inmobiliaria.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.inmobiliaria.java.model.Locator;
import com.inmobiliaria.java.service.ILocatorService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@CrossOrigin
public class LocatorController {
    @Autowired
    private ILocatorService locService;

    @GetMapping("/locators")
    public List<Locator>  getLocators() {
        return locService.getLocators();
    }
    
    @PostMapping("/locators/create")
    public String createLocator(@RequestBody Locator loc) {
        locService.saveLocator(loc);
        
        return "El locador fue creado correctamente";
    }
    
    @DeleteMapping("/locators/delete/{id}")
    public String deleteLocator(@PathVariable Long id) {
        locService.deleteLocator(id);

        return "El locador fue eliminado correctamente";
    }

    @PutMapping("locators/edit/{original_id}")
    public Locator editLocator(@PathVariable Long original_id, 
                                @RequestParam(required = false, name= "id") Long newId,
                                @RequestParam(required = false, name= "name") String newName,
                                @RequestParam(required = false, name= "lastname") String newLastname
                                ) {
        locService.editLocator(original_id, newId, newName, newLastname);

        Locator loc = locService.findLocator(original_id);
        
        return loc;
    }

    @PutMapping("locators/edit")
    public Locator editLocator(@RequestBody Locator loc) {
        locService.editLocator(loc);

        return locService.findLocator(loc.getId());
    }


}
