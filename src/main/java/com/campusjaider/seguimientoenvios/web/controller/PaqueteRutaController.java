package com.campusjaider.seguimientoenvios.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campusjaider.seguimientoenvios.domain.repository.PaqueteRepository;
import com.campusjaider.seguimientoenvios.domain.repository.RutaRepository;
import com.campusjaider.seguimientoenvios.persistence.entity.Paquete;
import com.campusjaider.seguimientoenvios.persistence.entity.Ruta;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/paquete/ruta")
public class PaqueteRutaController {
    
    @Autowired
    private PaqueteRepository paqueteRepository;
    @Autowired
    private RutaRepository rutaRepository;

    @GetMapping("/{idPaquete}/{idRuta}")
    @Transactional
    public void asignarRutaPaquete(@PathVariable Long idPaquete,@PathVariable Long idRuta) {
        Paquete paquete = paqueteRepository.findById(idPaquete).orElse(null);
        Ruta ruta = rutaRepository.findById(idRuta).orElse(null);

        if(paquete != null && ruta != null){
            paquete.addRuta(ruta);
            paqueteRepository.save(paquete);
        }
    }

}
