package com.inmobiliaria.java.repository;

import com.inmobiliaria.java.model.Renter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRenterRepository extends JpaRepository<Renter, Long> {
    boolean existsByDni(Long dni);
}
