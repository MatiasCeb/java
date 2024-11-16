package com.inmobiliaria.java.service;

import java.util.List;

import com.inmobiliaria.java.model.Contract;

public interface IContractService {
    Contract createContract(Long locatorId, Long renterId, Long propertyId);
    Contract updateContract(Long id, Contract contract);
    void deleteContract(Long id);
    List<Contract> getAllContracts();
    Contract getContractById(Long id);
    String generateMarkdown(Long contractId);
}
