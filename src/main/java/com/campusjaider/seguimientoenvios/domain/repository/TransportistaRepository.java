package com.campusjaider.seguimientoenvios.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campusjaider.seguimientoenvios.persistence.entity.Transportista;

public interface TransportistaRepository extends JpaRepository<Transportista, String>{
    
}
