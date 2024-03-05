package com.campusjaider.seguimientoenvios.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.campusjaider.seguimientoenvios.persistence.entity.Seguimiento;

public interface SeguimientoRepository extends JpaRepository<Seguimiento, Long>{
    
    @Modifying
    @Query(value = "DELETE FROM Seguimiento s WHERE s.id_paquete = :id", nativeQuery = true)
    void deleteSeguimientosByIdPaquete(Long id);

}
