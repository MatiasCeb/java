package com.inmobiliaria.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.inmobiliaria.java.model.Landlord;
import com.inmobiliaria.java.service.ILandlordService;

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
public class LandlordController {
    @Autowired
    private ILandlordService landlordService;

    @GetMapping("/landlords")
    public List<Landlord>  getLandlords() {
        return landlordService.getLandlords();
    }
    
    @PostMapping("/landlords/create")
    public String createLandlord(@RequestBody Landlord landlord) {
        landlordService.saveLandlord(landlord);
        
        return "El locador fue creado correctamente";
    }
    
    @DeleteMapping("/landlords/delete/{id}")
    public String deleteLandlord(@PathVariable Long id) {
        landlordService.deleteLandlord(id);

        return "El locador fue eliminado correctamente";
    }

    @PutMapping("landlords/edit/{original_id}")
    public Landlord editLandlord(@PathVariable Long original_id, 
                                @RequestParam(required = false, name= "id") Long newId,
                                @RequestParam(required = false, name= "name") String newName,
                                @RequestParam(required = false, name= "lastname") String newLastname
                                ) {
        landlordService.editLandlord(original_id, newId, newName, newLastname);

        Landlord landlord = landlordService.findLandlord(original_id);
        
        return landlord;
    }

    @PutMapping("landlords/edit")
    public Landlord editLandlord(@RequestBody Landlord landlord) {
        landlordService.editLandlord(landlord);

        return landlordService.findLandlord(landlord.getId());
    }


}
