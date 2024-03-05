package com.campusjaider.seguimientoenvios.domain.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusjaider.seguimientoenvios.domain.repository.PaqueteRepository;
import com.campusjaider.seguimientoenvios.domain.repository.SeguimientoRepository;
import com.campusjaider.seguimientoenvios.domain.service.SeguimientoService;
import com.campusjaider.seguimientoenvios.persistence.entity.Paquete;
import com.campusjaider.seguimientoenvios.persistence.entity.Seguimiento;

@Service
public class SeguimientoServiceImpl implements SeguimientoService {

    @Autowired
    private SeguimientoRepository seguimientoRepository;

    @Autowired
    private PaqueteRepository paqueteRepository;

    @Override
    public List<Seguimiento> getAll() {
        return seguimientoRepository.findAll();
    }

    @Override
    public Optional<Seguimiento> getById(Long id) {
        return seguimientoRepository.findById(id);
    }

    @Override
    public Seguimiento save(Seguimiento t) {
        return seguimientoRepository.save(t);
    }

    @Override
    public Seguimiento update(Seguimiento t) {
        Seguimiento seguimiento = seguimientoRepository.findById(t.getIdSeguimiento()).orElse(null);
        if(seguimiento != null){
            if(t.getEstadoEnvio() != null){
                seguimiento.setEstadoEnvio(t.getEstadoEnvio());
            }
            if(t.getFecha() != null){
                seguimiento.setFecha(t.getFecha());
            }
            if(t.getHora() != null){
                seguimiento.setHora(t.getHora());
            }
            if(t.getPaquete() != null){
                Paquete paquete = paqueteRepository.findById(t.getPaquete().getIdPaquete()).orElse(null);
                if(paquete != null){
                    seguimiento.setPaquete(paquete);
                }
            }
            return seguimientoRepository.save(seguimiento);
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        seguimientoRepository.deleteById(id);
    }
    
}
