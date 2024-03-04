package com.campusjaider.seguimientoenvios.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campusjaider.seguimientoenvios.domain.service.PaqueteService;
import com.campusjaider.seguimientoenvios.persistence.entity.Paquete;

@RestController
@RequestMapping("/paquete")
public class PaqueteController implements IController<Paquete, Long>{

    @Autowired
    private PaqueteService paqueteService;

    @Override
    @GetMapping()
    public List<Paquete> getAll() {
        return paqueteService.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public Optional<Paquete> getById(@PathVariable Long id) {
        return paqueteService.getById(id);
    }

    @Override
    @PostMapping()
    public Paquete save(@RequestBody Paquete t) {
        return paqueteService.save(t);
    }

    @Override
    @PutMapping()
    public Paquete update(@RequestBody Paquete t) {
        return paqueteService.update(t);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        paqueteService.deleteById(id);
    } 

    
    
}
