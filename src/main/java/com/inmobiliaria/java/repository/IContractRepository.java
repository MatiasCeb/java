package com.inmobiliaria.java.repository;

import com.inmobiliaria.java.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractRepository extends JpaRepository<Contract, Long> {
}

