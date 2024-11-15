package com.inmobiliaria.java.controller;

import com.inmobiliaria.java.model.Contract;
import com.inmobiliaria.java.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/contracts")
public class ContractController {

    @Autowired
    private ContractService contractService;

    @PostMapping
    public Contract createContract(@RequestBody Contract contract) {
        return contractService.createContract(contract);
    }

    @PutMapping("/{id}")
    public Contract updateContract(@PathVariable Long id, @RequestBody Contract contract) {
        return contractService.updateContract(id, contract);
    }

    @DeleteMapping("/{id}")
    public void deleteContract(@PathVariable Long id) {
        contractService.deleteContract(id);
    }

    @GetMapping
    public List<Contract> getAllContracts() {
        return contractService.getAllContracts();
    }

    @GetMapping("/{id}")
    public Contract getContractById(@PathVariable Long id) {
        return contractService.getContractById(id);
    }

    @GetMapping("/{id}/markdown")
    public ResponseEntity<String> getContractAsMarkdown(@PathVariable Long id) {
        Contract contract = contractService.getContractById(id);

        // Delegamos la generación de Markdown al servicio
        String markdown = contractService.generateMarkdown(contract);

        return ResponseEntity.ok()
                .header("Content-Type", "text/markdown")
                .body(markdown);
    }
}
