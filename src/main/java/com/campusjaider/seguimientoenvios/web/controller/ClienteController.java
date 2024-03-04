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

import com.campusjaider.seguimientoenvios.domain.service.ClienteService;
import com.campusjaider.seguimientoenvios.persistence.entity.Cliente;

@RestController
@RequestMapping("/cliente")
public class ClienteController implements IController<Cliente, String>{

    @Autowired
    private ClienteService clienteService;

    @Override
    @GetMapping()
    public List<Cliente> getAll() {
        return clienteService.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public Optional<Cliente> getById(@PathVariable String id) {
        return clienteService.getById(id);
    }

    @Override
    @PostMapping
    public Cliente save(@RequestBody Cliente t) {
        return clienteService.save(t);
    }

    @Override
    @PutMapping()
    public Cliente update(@RequestBody Cliente t) {
        return clienteService.update(t);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        clienteService.deleteById(id);
    }
    
}
