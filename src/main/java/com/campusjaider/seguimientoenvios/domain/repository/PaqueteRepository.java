package com.campusjaider.seguimientoenvios.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.campusjaider.seguimientoenvios.persistence.entity.Paquete;

public interface PaqueteRepository extends JpaRepository<Paquete, Long>{

    @Modifying
    @Query(value = "DELETE FROM Paquete pq WHERE pq.id_paquete = :id", nativeQuery = true)
    void deletePaqueteById(Long id);

}
