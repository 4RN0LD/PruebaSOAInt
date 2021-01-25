package com.soaint.prueba.service.impl;

import com.soaint.prueba.model.Producto;
import com.soaint.prueba.repository.ProductoRepository;
import com.soaint.prueba.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements IService<Producto> {

    @Autowired
    private ProductoRepository repo;

    @Override
    public List<Producto> findAll() {
        return repo.findAll();
    }

    @Override
    public Producto findById(Integer id) {
        Optional<Producto> op = repo.findById(id);
        return op.isPresent() ? op.get() : null;
    }

    @Override
    public Producto save(Producto obj) {
        return save(obj);
    }

    @Override
    public Producto update(Producto obj) {
        return save(obj);
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public Page<Producto> listarPageable(Pageable pageable) {
        return null;
    }
}
