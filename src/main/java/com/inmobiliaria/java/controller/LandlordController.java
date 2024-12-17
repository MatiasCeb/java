package com.inmobiliaria.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.inmobiliaria.java.dto.LandlordDTO;
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
    public List<LandlordDTO>  getLandlords() {
        return landlordService.getLandlords();
    }
    
    @PostMapping("/landlords/create")
    public String createLandlord(@RequestBody LandlordDTO landlordDTO) {
        landlordService.saveLandlord(landlordDTO);
        
        return "El locador fue creado correctamente";
    }
    
    @DeleteMapping("/landlords/delete/{id}")
    public String deleteLandlord(@PathVariable Long id) {
        landlordService.deleteLandlord(id);

        return "El locador fue eliminado correctamente";
    }

    @PutMapping("landlords/edit")
    public Landlord editLandlord(@RequestBody LandlordDTO landlordDto) {
    Landlord landlord = landlordService.findLandlord(landlordDto.getId());

    landlordService.updateLandlordFields(landlord, landlordDto);

    return landlordService.findLandlord(landlord.getId());
    }


}
