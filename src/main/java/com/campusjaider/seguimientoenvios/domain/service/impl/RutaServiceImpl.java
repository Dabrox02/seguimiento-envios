package com.campusjaider.seguimientoenvios.domain.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusjaider.seguimientoenvios.domain.repository.RutaRepository;
import com.campusjaider.seguimientoenvios.domain.repository.TransportistaRepository;
import com.campusjaider.seguimientoenvios.domain.service.RutaService;
import com.campusjaider.seguimientoenvios.persistence.entity.Ruta;
import com.campusjaider.seguimientoenvios.persistence.entity.Transportista;

import jakarta.transaction.Transactional;

@Service
public class RutaServiceImpl implements RutaService{

    @Autowired
    private RutaRepository rutaRepository;

    @Autowired
    private TransportistaRepository transportistaRepository;

    @Override
    @Transactional
    public List<Ruta> getAll() {
        return rutaRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Ruta> getById(Long id) {
        return rutaRepository.findById(id);
    }

    @Override
    @Transactional
    public Ruta save(Ruta t) {
        Transportista transportista = transportistaRepository.findById(t.getTransportista().getNitTransportista()).orElse(null);
        if(transportista != null){
            t.setTransportista(transportista);
            return rutaRepository.save(t);
        }
        return null;
    }

    @Override
    @Transactional
    public Ruta update(Ruta t) {
        Ruta ruta = rutaRepository.findById(t.getIdRuta()).orElse(null);
        if(ruta != null){
            if(t.getDireccionOrigen() != null){
                ruta.setDireccionOrigen(t.getDireccionOrigen());
            }
            if(t.getDireccionDestino() != null){
                ruta.setDireccionDestino(t.getDireccionDestino());
            }
            if(t.getTransportista() != null){
                Transportista transportista = transportistaRepository.findById(t.getTransportista().getNitTransportista()).orElse(null);
                if(transportista != null){
                    ruta.setTransportista(transportista);
                }
            }
            return rutaRepository.save(ruta);
        }
        return null;
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        rutaRepository.deleteByIdJPQL(id);
    }
    
}
