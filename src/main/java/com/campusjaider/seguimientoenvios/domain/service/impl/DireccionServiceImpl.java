package com.campusjaider.seguimientoenvios.domain.service.impl;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusjaider.seguimientoenvios.domain.repository.DireccionRepository;
import com.campusjaider.seguimientoenvios.domain.service.DireccionService;
import com.campusjaider.seguimientoenvios.persistence.entity.Direccion;

import jakarta.persistence.Column;
import jakarta.transaction.Transactional;

@Service
public class DireccionServiceImpl implements DireccionService{
    
    @Autowired
    private DireccionRepository direccionRepository;

    @Override
    @Transactional
    public List<Direccion> getAll() {
        List<Direccion> direcciones = direccionRepository.findAll();
        return direcciones;
    }

    @Override
    @Transactional
    public Optional<Direccion> getById(Long id) {
        Optional<Direccion> direccion = direccionRepository.findById(id);
        return direccion;
    }

    @Override
    @Transactional
    public Direccion save(Direccion t) {
        return direccionRepository.save(t);
    }
    @Override
    @Transactional
    public Direccion update(Direccion t) {
        Optional<Direccion> optDireccion = direccionRepository.findById(t.getIdDireccion());
        if (optDireccion.isPresent()) {
            Direccion direccionOld = optDireccion.get();
            
            for (Field field : t.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(Column.class)) {
                    try {
                        field.setAccessible(true);
                        Object value = field.get(t); 
                        if (value != null) {
                            field.set(direccionOld, value);
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            return direccionRepository.save(direccionOld);
        }
        return null;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        direccionRepository.deleteById(id);
    }




}
