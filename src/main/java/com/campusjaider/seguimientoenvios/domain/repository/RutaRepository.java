package com.campusjaider.seguimientoenvios.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campusjaider.seguimientoenvios.persistence.entity.Ruta;

public interface RutaRepository extends JpaRepository<Ruta, Long>{
    
}
