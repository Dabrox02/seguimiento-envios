package com.campusjaider.seguimientoenvios.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campusjaider.seguimientoenvios.persistence.entity.Paquete;

public interface PaqueteRepository extends JpaRepository<Paquete, Long>{
    
}
