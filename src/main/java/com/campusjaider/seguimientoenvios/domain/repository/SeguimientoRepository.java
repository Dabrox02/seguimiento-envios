package com.campusjaider.seguimientoenvios.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campusjaider.seguimientoenvios.persistence.entity.Seguimiento;

public interface SeguimientoRepository extends JpaRepository<Seguimiento, Long>{
    
}
