package com.inmobiliaria.java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inmobiliaria.java.model.Property;

@Repository
public interface IPropertyRepository  extends JpaRepository<Property, Long> {
    List<Property> findByLocatorId(Long locatorId);
}
