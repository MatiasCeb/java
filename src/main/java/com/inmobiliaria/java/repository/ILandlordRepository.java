package com.inmobiliaria.java.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inmobiliaria.java.model.Landlord;

@Repository
public interface ILandlordRepository extends JpaRepository<Landlord, Long> {

}
