package com.inmobiliaria.java.service;

import com.inmobiliaria.java.model.Contract;
import com.inmobiliaria.java.repository.IContractRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {

    @Autowired
    private IContractRepository contractRepository;

    @Override
    public Contract createContract(Contract contract) {
        return contractRepository.save(contract);
    }

    @Override
    public Contract updateContract(Long id, Contract contract) {
        Contract existingContract = contractRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contract not found"));

        existingContract.setLocator(contract.getLocator());
        existingContract.setRenter(contract.getRenter());
        existingContract.setProperty(contract.getProperty());
        existingContract.setStartDate(contract.getStartDate());
        existingContract.setEndDate(contract.getEndDate());

        return contractRepository.save(existingContract);
    }

    @Override
    public void deleteContract(Long id) {
        contractRepository.deleteById(id);
    }

    @Override
    public List<Contract> getAllContracts() {
        return contractRepository.findAll();
    }

    @Override
    public Contract getContractById(Long id) {
        return contractRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrato no encontrado"));
    }

    @Override
    public String generateMarkdown(Contract contract) {
        return String.format("""
            # Contrato de Locación
            
            **Locador:** %s %s  
            **DNI Locador:** DNIgenérico  
            
            **Locatario:** %s %s  
            **DNI Locatario:** DNIgenérico  
            
            **Inmueble:** address genérica  
            
            **Fecha de Inicio:** %s  
            **Fecha de Finalización:** %s  
            
            ---
            **Cláusulas Generales:**
            
            1. El locador entrega en locación el inmueble mencionado al locatario, quien lo recibe en perfectas condiciones.
            2. El locatario deberá abonar el alquiler en tiempo y forma según lo acordado entre las partes.
            3. Cualquier incumplimiento de las cláusulas establecidas será motivo de rescisión del contrato.
            
            ---
            **Firma del Locador:**  
            ___________________________  
            
            **Firma del Locatario:**  
            ___________________________
            
            ---
            """,
            contract.getLocator().getName(),
            contract.getLocator().getLastname(),
            contract.getRenter().getName(),
            contract.getRenter().getLastname(),
            contract.getStartDate(),
            contract.getEndDate()
        );
    }
}
