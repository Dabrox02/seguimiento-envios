package com.campusjaider.seguimientoenvios.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusjaider.seguimientoenvios.domain.repository.PaqueteRepository;
import com.campusjaider.seguimientoenvios.domain.repository.RutaRepository;
import com.campusjaider.seguimientoenvios.persistence.entity.Paquete;
import com.campusjaider.seguimientoenvios.persistence.entity.Ruta;

@Service
public class PaqueteRutaServiceImpl {
    
    @Autowired
    private PaqueteRepository paqueteRepository;
    @Autowired
    private RutaRepository rutaRepository;

    public void asignarRutaPaquete(Long idPaquete,Long idRuta) {
        Paquete paquete = paqueteRepository.findById(idPaquete).orElse(null);
        Ruta ruta = rutaRepository.findById(idRuta).orElse(null);

        if(paquete != null && ruta != null){
            paquete.addRuta(ruta);
            paqueteRepository.save(paquete);
        }
    }

}
