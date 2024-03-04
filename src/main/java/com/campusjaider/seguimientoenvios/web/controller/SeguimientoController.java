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

import com.campusjaider.seguimientoenvios.domain.service.SeguimientoService;
import com.campusjaider.seguimientoenvios.persistence.entity.Seguimiento;

@RestController
@RequestMapping("/seguimiento")
public class SeguimientoController implements IController<Seguimiento, Long>{

    @Autowired
    private SeguimientoService seguimientoService;

    @Override
    @GetMapping()
    public List<Seguimiento> getAll() {
        return seguimientoService.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public Optional<Seguimiento> getById(@PathVariable Long id) {
        return seguimientoService.getById(id);
    }

    @Override
    @PostMapping()
    public Seguimiento save(@RequestBody Seguimiento t) {
        return seguimientoService.save(t);
    }

    @Override
    @PutMapping()
    public Seguimiento update(@RequestBody Seguimiento t) {
        return seguimientoService.update(t);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        seguimientoService.deleteById(id);
    }
    
}
