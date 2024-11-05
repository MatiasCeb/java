package com.inmobiliaria.java.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inmobiliaria.java.model.Locator;

@Repository
public interface ILocatorRepository extends JpaRepository<Locator, Long> {

}
