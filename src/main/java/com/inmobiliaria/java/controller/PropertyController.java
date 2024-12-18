package com.inmobiliaria.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inmobiliaria.java.dto.PropertyDTO;
import com.inmobiliaria.java.model.Landlord;
import com.inmobiliaria.java.model.Property;
import com.inmobiliaria.java.service.IPropertyService;

@RestController
@CrossOrigin
public class PropertyController {
    @Autowired
    private IPropertyService properService;

    @GetMapping("/properties")
    public List<PropertyDTO>  getProperties() {
        return properService.getProperties();
    }

    @GetMapping("/property/{id}")
    public Property  getProperty(@PathVariable Long id) {
        return properService.getProperty(id);
    }
    
    @PostMapping("/properties/create")
    public String createProperty(@RequestBody PropertyDTO properDTO) {
        properService.saveProperty(properDTO);
        
        return "La propiedad fue creada correctamente";
    }
    
    @DeleteMapping("/properties/delete/{id}")
    public String deleteProperty(@PathVariable Long id) {
        properService.deleteProperty(id);

        return "La propiedad fue eliminada correctamente";
    }


    // DOING: solucionar Cannot invoke "com.inmobiliaria.java.model.Person.getId()" because "this.person" is null
    @PutMapping("properties/edit")
    public Property editProperty(@RequestBody PropertyDTO properDTO) {
        Property property = properService.findProperty(properDTO.getId());

        properService.editProperty(property, properDTO);

        return properService.findProperty(property.getId());
    }

    @GetMapping("/properties/landlord/{landlordId}")
    public ResponseEntity<List<Property>> getPropertiesByPersonId(@PathVariable Long personId) {
        List<Property> properties = properService.getPropertiesByPersonId(personId);
        return ResponseEntity.ok(properties);
    }
}
