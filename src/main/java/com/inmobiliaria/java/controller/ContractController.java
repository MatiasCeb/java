package com.inmobiliaria.java.controller;

import com.inmobiliaria.java.model.Contract;
import com.inmobiliaria.java.model.ContractRequest;
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
    public ResponseEntity<Contract> createContract(@RequestBody ContractRequest contractRequest) {
        Contract contract = contractService.createContract(
                contractRequest.getLandlordId(),
                contractRequest.getRenterId(),
                contractRequest.getPropertyId()
        );
        return ResponseEntity.ok(contract);
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
        String markdown = contractService.generateMarkdown(id);
        return ResponseEntity.ok()
                .header("Content-Type", "text/markdown")
                .body(markdown);
    }

    // TODO: Implementar endpoint para mostrar contratos en base a una propiedad determinada.-
}
