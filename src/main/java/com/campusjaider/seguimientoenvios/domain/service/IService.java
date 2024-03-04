package com.campusjaider.seguimientoenvios.domain.service;

import java.util.List;
import java.util.Optional;

public interface IService <T, U>{
    List<T> getAll();
    Optional<T> getById(U id);
    T save(T t);
    T update(T t);
    void delete(U id);
}
