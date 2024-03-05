package com.campusjaider.seguimientoenvios.domain.service.impl;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusjaider.seguimientoenvios.domain.repository.ClienteRepository;
import com.campusjaider.seguimientoenvios.domain.repository.PaqueteRepository;
import com.campusjaider.seguimientoenvios.domain.repository.SeguimientoRepository;
import com.campusjaider.seguimientoenvios.domain.service.PaqueteService;
import com.campusjaider.seguimientoenvios.persistence.entity.Cliente;
import com.campusjaider.seguimientoenvios.persistence.entity.Paquete;

import jakarta.transaction.Transactional;

@Service
public class PaqueteServiceImpl implements PaqueteService {

    @Autowired
    private PaqueteRepository paqueteRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private SeguimientoRepository seguimientoRepository;

    @Override
    @Transactional
    public List<Paquete> getAll() {
        return paqueteRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Paquete> getById(Long id) {
        return paqueteRepository.findById(id);
    }

    @Override
    @Transactional
    public Paquete save(Paquete t) {
        Cliente remitente = t.getRemitente();
        Cliente destinatario = t.getDestinatario();
        if (remitente != null && destinatario != null) {
            if (remitente.getDniCliente() != null && destinatario.getDniCliente() != null) {
                Optional<Cliente> remitenteOpt = clienteRepository.findById(remitente.getDniCliente());
                Optional<Cliente> destinatarioOpt = clienteRepository.findById(destinatario.getDniCliente());
                t.setRemitente(remitenteOpt.get());
                t.setDestinatario(destinatarioOpt.get());
            }
        }
        return paqueteRepository.save(t);
    }

    @Override
    @Transactional
    public Paquete update(Paquete t) {
        Optional<Paquete> optPaquete = paqueteRepository.findById(t.getIdPaquete());
        if (optPaquete.isPresent()) {
            Paquete paqueteOld = optPaquete.get();

            for (Field field : paqueteOld.getClass().getDeclaredFields()) {
                try {
                    field.setAccessible(true);
                    Object value = field.get(t);
                    if (value != null) {
                        field.set(paqueteOld, value);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            return paqueteRepository.save(paqueteOld);
        }
        return null;
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        seguimientoRepository.deleteSeguimientosByIdPaquete(id);
        paqueteRepository.deletePaqueteById(id);
    }

}
