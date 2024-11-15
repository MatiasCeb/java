package com.inmobiliaria.java.controller;

import com.inmobiliaria.java.model.Renter;
import com.inmobiliaria.java.service.RenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/renters")
public class RenterController {

    @Autowired
    private RenterService renterService;

    @PostMapping
    public Renter createRenter(@RequestBody Renter renter) {
        return renterService.createRenter(renter);
    }

    @PutMapping("/{id}")
    public Renter updateRenter(@PathVariable Long id, @RequestBody Renter renter) {
        return renterService.updateRenter(id, renter);
    }

    @DeleteMapping("/{id}")
    public void deleteRenter(@PathVariable Long id) {
        renterService.deleteRenter(id);
    }

    @GetMapping
    public List<Renter> getAllRenters() {
        return renterService.getAllRenters();
    }

    @GetMapping("/{id}")
    public Renter getRenterById(@PathVariable Long id) {
        return renterService.getRenterById(id);
    }
}
