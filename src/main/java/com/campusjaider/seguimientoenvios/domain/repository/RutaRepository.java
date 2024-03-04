package com.campusjaider.seguimientoenvios.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.campusjaider.seguimientoenvios.persistence.entity.Ruta;

public interface RutaRepository extends JpaRepository<Ruta, Long>{
    
    @Modifying
    @Query("DELETE FROM Ruta r WHERE r.idRuta = :id")
    void deleteByIdJPQL(Long id);
}
