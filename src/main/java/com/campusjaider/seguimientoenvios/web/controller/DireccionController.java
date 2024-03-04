package com.campusjaider.seguimientoenvios.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campusjaider.seguimientoenvios.domain.service.DireccionService;
import com.campusjaider.seguimientoenvios.persistence.entity.Direccion;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/direccion")
public class DireccionController implements IController<Direccion, Long>{
    
    @Autowired
    private DireccionService direccionService;

    @Override
    @GetMapping()
    public List<Direccion> getAll() {
        return direccionService.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public Optional<Direccion> getById(@PathVariable Long id) {
        return direccionService.getById(id);
    }

    @Override
    @PostMapping()
    public Direccion save(@RequestBody Direccion t) {
        return direccionService.save(t);
    }

    @Override
    @PutMapping()
    public Direccion update(@RequestBody Direccion t) {
        return direccionService.update(t);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        direccionService.deleteById(id);
    }

}
