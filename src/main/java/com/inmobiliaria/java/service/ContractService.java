package com.inmobiliaria.java.service;

import com.inmobiliaria.java.model.Contract;
import com.inmobiliaria.java.model.Landlord;
import com.inmobiliaria.java.model.Property;
import com.inmobiliaria.java.model.Renter;
import com.inmobiliaria.java.repository.IContractRepository;
import com.inmobiliaria.java.repository.ILandlordRepository;
import com.inmobiliaria.java.repository.IPropertyRepository;
import com.inmobiliaria.java.repository.IRenterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ContractService implements IContractService {

    @Autowired
    private IContractRepository contractRepository;

    @Autowired
    private ILandlordRepository landlordRepository;

    @Autowired
    private IRenterRepository renterRepository;

    @Autowired
    private IPropertyRepository propertyRepository;

    @Override
    public Contract createContract(Long landlordId, Long renterId, Long propertyId) {
        Optional<Landlord> landlord = landlordRepository.findById(landlordId);
        Optional<Renter> renter = renterRepository.findById(renterId);
        Optional<Property> property = propertyRepository.findById(propertyId);

        if (landlord.isEmpty() || renter.isEmpty() || property.isEmpty()) {
            throw new RuntimeException("Landlord, Renter, or Property not found");
        }

        Contract contract = new Contract();
        contract.setLandlord(landlord.get());
        contract.setRenter(renter.get());
        contract.setProperty(property.get());

        return contractRepository.save(contract);
    }

    @Override
    public Contract updateContract(Long id, Contract contract) {
        Contract existingContract = contractRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contract not found"));

        existingContract.setLandlord(contract.getLandlord());
        existingContract.setRenter(contract.getRenter());
        existingContract.setProperty(contract.getProperty());

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
    public String generateMarkdown(Long contractId) {
        Optional<Contract> contract = contractRepository.findById(contractId);

        if (contract.isEmpty()) {
            throw new RuntimeException("Contract not found");
        }

        Contract contractData = contract.get();
        return String.format("""
            # Contrato de Locación
            
            **Locador:** %s %s  
            **DNI Locador:** DNIgenérico  
            
            **Locatario:** %s %s  
            **DNI Locatario:** DNIgenérico  
            
            **Inmueble:** address genérica  
            
            ---
            **Cláusulas Generales:**
            
            1. El locador entrega en locación el inmueble mencionado al locatario, quien lo recibe en perfectas condiciones.
            2. El locatario deberá abonar el alquiler en tiempo y forma según lo acordado entre las partes.
            3. Cualquier incumplimiento de las cláusulas establecidas será motivo de rescisión del contrato.



                1. El locador entrega en locación el inmueble mencionado al locatario, quien lo recibe en perfectas condiciones.
            2. El locatario deberá abonar el alquiler en tiempo y forma según lo acordado entre las partes.
            3. Cualquier incumplimiento de las cláusulas establecidas será motivo de rescisión del contrato.




                1. El locador entrega en locación el inmueble mencionado al locatario, quien lo recibe en perfectas condiciones.
            2. El locatario deberá abonar el alquiler en tiempo y forma según lo acordado entre las partes.
            3. Cualquier incumplimiento de las cláusulas establecidas será motivo de rescisión del contrato.




                1. El locador entrega en locación el inmueble mencionado al locatario, quien lo recibe en perfectas condiciones.
            2. El locatario deberá abonar el alquiler en tiempo y forma según lo acordado entre las partes.
            3. Cualquier incumplimiento de las cláusulas establecidas será motivo de rescisión del contrato.




                1. El locador entrega en locación el inmueble mencionado al locatario, quien lo recibe en perfectas condiciones.
            2. El locatario deberá abonar el alquiler en tiempo y forma según lo acordado entre las partes.
            3. Cualquier incumplimiento de las cláusulas establecidas será motivo de rescisión del contrato.





                1. El locador entrega en locación el inmueble mencionado al locatario, quien lo recibe en perfectas condiciones.
            2. El locatario deberá abonar el alquiler en tiempo y forma según lo acordado entre las partes.
            3. Cualquier incumplimiento de las cláusulas establecidas será motivo de rescisión del contrato.




                1. El locador entrega en locación el inmueble mencionado al locatario, quien lo recibe en perfectas condiciones.
            2. El locatario deberá abonar el alquiler en tiempo y forma según lo acordado entre las partes.
            3. Cualquier incumplimiento de las cláusulas establecidas será motivo de rescisión del contrato.





                1. El locador entrega en locación el inmueble mencionado al locatario, quien lo recibe en perfectas condiciones.
            2. El locatario deberá abonar el alquiler en tiempo y forma según lo acordado entre las partes.
            3. Cualquier incumplimiento de las cláusulas establecidas será motivo de rescisión del contrato.




                1. El locador entrega en locación el inmueble mencionado al locatario, quien lo recibe en perfectas condiciones.
            2. El locatario deberá abonar el alquiler en tiempo y forma según lo acordado entre las partes.
            3. Cualquier incumplimiento de las cláusulas establecidas será motivo de rescisión del contrato.




                1. El locador entrega en locación el inmueble mencionado al locatario, quien lo recibe en perfectas condiciones.
            2. El locatario deberá abonar el alquiler en tiempo y forma según lo acordado entre las partes.
            3. Cualquier incumplimiento de las cláusulas establecidas será motivo de rescisión del contrato.




                1. El locador entrega en locación el inmueble mencionado al locatario, quien lo recibe en perfectas condiciones.
            2. El locatario deberá abonar el alquiler en tiempo y forma según lo acordado entre las partes.
            3. Cualquier incumplimiento de las cláusulas establecidas será motivo de rescisión del contrato.





                1. El locador entrega en locación el inmueble mencionado al locatario, quien lo recibe en perfectas condiciones.
            2. El locatario deberá abonar el alquiler en tiempo y forma según lo acordado entre las partes.
            3. Cualquier incumplimiento de las cláusulas establecidas será motivo de rescisión del contrato.





                1. El locador entrega en locación el inmueble mencionado al locatario, quien lo recibe en perfectas condiciones.
            2. El locatario deberá abonar el alquiler en tiempo y forma según lo acordado entre las partes.
            3. Cualquier incumplimiento de las cláusulas establecidas será motivo de rescisión del contrato.
                1. El locador entrega en locación el inmueble mencionado al locatario, quien lo recibe en perfectas condiciones.
                    1. El locador entrega en locación el inmueble mencionado al locatario, quien lo recibe en perfectas condiciones.
                        1. El locador entrega en locación el inmueble mencionado al locatario, quien lo recibe en perfectas condiciones.
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
            contractData.getLandlord().getName(),
            contractData.getLandlord().getLastname(),
            contractData.getRenter().getName(),
            contractData.getRenter().getLastname()
        );
    }
}
