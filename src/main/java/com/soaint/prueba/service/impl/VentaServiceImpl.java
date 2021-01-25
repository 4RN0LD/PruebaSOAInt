package com.soaint.prueba.service.impl;

import com.soaint.prueba.model.Venta;
import com.soaint.prueba.repository.VentaRepository;
import com.soaint.prueba.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaServiceImpl implements IService<Venta> {

    @Autowired
    private VentaRepository repo;

    @Override
    public List<Venta> findAll() {
        return repo.findAll();
    }

    @Override
    public Venta findById(Integer id) {
        Optional<Venta> op = repo.findById(id);
        return op.isPresent() ? op.get() : null;
    }

    @Override
    public Venta save(Venta obj) {
        return save(obj);
    }

    @Override
    public Venta update(Venta obj) {
        return save(obj);
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public Page<Venta> listarPageable(Pageable pageable) {
        return null;
    }
}
