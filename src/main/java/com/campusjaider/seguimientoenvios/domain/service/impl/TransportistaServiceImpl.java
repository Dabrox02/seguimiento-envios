package com.campusjaider.seguimientoenvios.domain.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusjaider.seguimientoenvios.domain.repository.TransportistaRepository;
import com.campusjaider.seguimientoenvios.domain.service.TransportistaService;
import com.campusjaider.seguimientoenvios.persistence.entity.Transportista;

@Service
public class TransportistaServiceImpl implements TransportistaService{

    @Autowired
    private TransportistaRepository transportistaRepository;

    @Override
    public List<Transportista> getAll() {
        return transportistaRepository.findAll();
    }

    @Override
    public Optional<Transportista> getById(String id) {
        return transportistaRepository.findById(id);
    }

    @Override
    public Transportista save(Transportista t) {
        return transportistaRepository.save(t);
    }

    @Override
    public Transportista update(Transportista t) {
        return transportistaRepository.save(t);
    }

    @Override
    public void deleteById(String id) {
        transportistaRepository.deleteById(id);
    }
    
}
