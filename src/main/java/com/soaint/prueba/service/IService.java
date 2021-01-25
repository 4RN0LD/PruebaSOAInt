package com.soaint.prueba.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IService<T> {

    List<T> findAll();

    T findById(Integer id);

    T save(T obj);

    T update(T obj);

    void delete(Integer id);

    Page<T> listarPageable(Pageable pageable);
}
