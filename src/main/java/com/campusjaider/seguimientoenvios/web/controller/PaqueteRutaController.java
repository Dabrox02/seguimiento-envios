package com.campusjaider.seguimientoenvios.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campusjaider.seguimientoenvios.domain.service.impl.PaqueteRutaServiceImpl;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/paquete/ruta")
public class PaqueteRutaController {
    
    @Autowired
    private PaqueteRutaServiceImpl paqueteRutaServiceImpl;

    @GetMapping("/{idPaquete}/{idRuta}")
    @Transactional
    public void asignarRutaPaquete(@PathVariable Long idPaquete,@PathVariable Long idRuta) {
        paqueteRutaServiceImpl.asignarRutaPaquete(idPaquete, idRuta);
    }

}
