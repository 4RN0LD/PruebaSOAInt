package com.soaint.prueba.controller;

import com.soaint.prueba.dto.ErrorMessage;
import com.soaint.prueba.model.DetalleVenta;
import com.soaint.prueba.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/detalles")
public class DetalleVentaController{

    @Autowired
    private IService<DetalleVenta> service;

    
    @GetMapping
    public ResponseEntity<List<DetalleVenta>> listar() {
        List<DetalleVenta> detalleVentas = service.findAll();
        return new ResponseEntity(detalleVentas, HttpStatus.OK);
    }

    
    @PostMapping
    public Object registrar(@RequestBody DetalleVenta obj) {
        DetalleVenta detalleVenta = service.save(obj);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(detalleVenta.getIdDetalleVenta())
                .toUri();
        return ResponseEntity.created(location);
    }

    
//    @PutMapping
//    public ResponseEntity<DetalleVenta> modificar(@RequestBody DetalleVenta obj) {
//        DetalleVenta detalleVenta = service.update(obj);
//        return new ResponseEntity<DetalleVenta>(detalleVenta, HttpStatus.OK);
//    }
//
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
//        service.delete(id);
//        return new ResponseEntity<Object>(HttpStatus.OK);
//    }

    
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id) {
        DetalleVenta detalleVenta = service.findById(id);
        if (detalleVenta == null) {
            ErrorMessage errorMessage = new ErrorMessage("404",
                    "Elemento no encontrado",
                    "0001",
                    "No existe el objeto en base de datos");
            return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<DetalleVenta>(detalleVenta, HttpStatus.OK);
    }
}
