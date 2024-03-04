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

import com.campusjaider.seguimientoenvios.domain.service.TransportistaService;
import com.campusjaider.seguimientoenvios.persistence.entity.Transportista;

@RestController
@RequestMapping("/transportista")
public class TransportistaController implements IController<Transportista, String> {

    @Autowired
    private TransportistaService transportistaService;

    @Override
    @GetMapping()
    public List<Transportista> getAll() {
        return transportistaService.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public Optional<Transportista> getById(@PathVariable String id) {
        return transportistaService.getById(id);
    }

    @Override
    @PostMapping()
    public Transportista save(@RequestBody Transportista t) {
        return transportistaService.save(t);
    }

    @Override
    @PutMapping()
    public Transportista update(@RequestBody Transportista t) {
        return transportistaService.update(t);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        transportistaService.deleteById(id);
    }
    
}
