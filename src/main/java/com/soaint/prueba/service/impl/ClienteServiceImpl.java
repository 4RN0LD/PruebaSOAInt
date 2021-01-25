package com.soaint.prueba.service.impl;

import com.soaint.prueba.model.Cliente;
import com.soaint.prueba.repository.ClienteRepository;
import com.soaint.prueba.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements IService<Cliente> {

    @Autowired
    private ClienteRepository repo;

    @Override
    public List<Cliente> findAll() {
        return repo.findAll();
    }

    @Override
    public Cliente findById(Integer id) {
        Optional<Cliente> op = repo.findById(id);
        return op.isPresent() ? op.get() : null;
    }

    @Override
    public Cliente save(Cliente obj) {
        return repo.save(obj);
    }

    @Override
    public Cliente update(Cliente obj) {
        return repo.save(obj);
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public Page<Cliente> listarPageable(Pageable pageable) {
        return null;
    }
}
