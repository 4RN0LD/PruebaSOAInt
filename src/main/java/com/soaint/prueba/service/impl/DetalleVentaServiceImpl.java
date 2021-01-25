package com.soaint.prueba.service.impl;

import com.soaint.prueba.model.DetalleVenta;
import com.soaint.prueba.repository.DetalleVentaRepository;
import com.soaint.prueba.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleVentaServiceImpl implements IService<DetalleVenta> {

    @Autowired
    private DetalleVentaRepository repo;

    @Override
    public List<DetalleVenta> findAll() {
        return repo.findAll();
    }

    @Override
    public DetalleVenta findById(Integer id) {
        Optional<DetalleVenta> op = repo.findById(id);
        return op.isPresent() ? op.get() : null;
    }

    @Override
    public DetalleVenta save(DetalleVenta obj) {
        return save(obj);
    }

    @Override
    public DetalleVenta update(DetalleVenta obj) {
        return save(obj);
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public Page<DetalleVenta> listarPageable(Pageable pageable) {
        return null;
    }
}
