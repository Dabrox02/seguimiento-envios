package com.campusjaider.seguimientoenvios.domain.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusjaider.seguimientoenvios.domain.repository.RutaRepository;
import com.campusjaider.seguimientoenvios.domain.service.RutaService;
import com.campusjaider.seguimientoenvios.persistence.entity.Ruta;

@Service
public class RutaServiceImpl implements RutaService{

    @Autowired
    private RutaRepository rutaRepository;

    @Override
    public List<Ruta> getAll() {
        return rutaRepository.findAll();
    }

    @Override
    public Optional<Ruta> getById(Long id) {
        return rutaRepository.findById(id);
    }

    @Override
    public Ruta save(Ruta t) {
        return rutaRepository.save(t);
    }

    @Override
    public Ruta update(Ruta t) {
        return rutaRepository.save(t);
    }

    @Override
    public void deleteById(Long id) {
        rutaRepository.deleteById(id);
    }
    
}
