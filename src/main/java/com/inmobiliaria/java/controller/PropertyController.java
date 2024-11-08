package com.inmobiliaria.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inmobiliaria.java.model.Property;
import com.inmobiliaria.java.service.IPropertyService;

@RestController
public class PropertyController {
    @Autowired
    private IPropertyService properService;

    @GetMapping("/properties")
    public List<Property>  getProperties() {
        return properService.getProperties();
    }
    
    @PostMapping("/properties/create")
    public String createProperty(@RequestBody Property proper) {
        properService.saveProperty(proper);
        
        return "La propiedad fue creada correctamente";
    }
    
    @DeleteMapping("/properties/delete/{id}")
    public String deleteProperty(@PathVariable Long id) {
        properService.deleteProperty(id);

        return "La propiedad fue eliminada correctamente";
    }

        @PutMapping("properties/edit")
    public Property editProperty(@RequestBody Property proper) {
        properService.editProperty(proper);

        return properService.findProperty(proper.getId());
    }
}
