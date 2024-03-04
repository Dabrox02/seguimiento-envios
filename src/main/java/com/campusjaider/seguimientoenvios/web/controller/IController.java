package com.campusjaider.seguimientoenvios.web.controller;

import java.util.List;
import java.util.Optional;

public interface IController<T,U>{
    List<T> getAll();
    Optional<T> getById(U id);
    T save(T t);
    T update(T t);
    void delete(U id);
}
