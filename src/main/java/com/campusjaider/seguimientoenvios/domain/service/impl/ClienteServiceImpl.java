package com.campusjaider.seguimientoenvios.domain.service.impl;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusjaider.seguimientoenvios.domain.repository.ClienteRepository;
import com.campusjaider.seguimientoenvios.domain.repository.DireccionRepository;
import com.campusjaider.seguimientoenvios.domain.service.ClienteService;
import com.campusjaider.seguimientoenvios.persistence.entity.Cliente;
import com.campusjaider.seguimientoenvios.persistence.entity.Direccion;

import jakarta.persistence.Column;
import jakarta.transaction.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private DireccionRepository direccionRepository;

    @Override
    @Transactional
    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Cliente> getById(String id) {
        return clienteRepository.findById(id);
    }

    @Override
    @Transactional
    public Cliente save(Cliente cliente) {
        Direccion direccion = cliente.getDireccionCliente();
        if (direccion != null && direccion.getIdDireccion() != null) {
            Optional<Direccion> direccionExistente = direccionRepository.findById(direccion.getIdDireccion());
            if (direccionExistente.isPresent()) {
                if(direccionExistente.get().getCliente() != null){
                    throw new RuntimeException("La dirección ya está registrada");
                } else {
                    direccionExistente.get().setCliente(cliente);
                    cliente.setDireccionCliente(direccionExistente.get());
                }
            }
        }
        return clienteRepository.save(cliente);
    }
    

    @Override
    @Transactional
    public Cliente update(Cliente t) {
        Optional<Cliente> optCliente = clienteRepository.findById(t.getDniCliente());
        if (optCliente.isPresent()) {
            Cliente clienteOld = optCliente.get();
            
            for (Field field : t.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(Column.class)) {
                    try {
                        field.setAccessible(true);
                        Object value = field.get(t); 
                        if (value != null) {
                            field.set(clienteOld, value);
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            return clienteRepository.save(clienteOld);
        }
        return null;
    }

    @Override
    @Transactional
    public void deleteById(String id) {
        clienteRepository.deleteById(id);
    }
    
}
