package com.campusjaider.seguimientoenvios.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campusjaider.seguimientoenvios.persistence.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String>{
    
}
