package com.soaint.prueba.controller;

import com.soaint.prueba.dto.ErrorMessage;
import com.soaint.prueba.model.Venta;
import com.soaint.prueba.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private IService<Venta> service;

    
    @GetMapping
    public ResponseEntity<List<Venta>> listar() {
        List<Venta> ventas = service.findAll();
        return new ResponseEntity(ventas, HttpStatus.OK);
    }

    
    @PostMapping
    public Object registrar(@RequestBody Venta obj) {
        Venta venta = service.save(obj);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(venta.getIdVenta())
                .toUri();
        return ResponseEntity.created(location);
    }

    
//    @PutMapping
//    public ResponseEntity<Venta> modificar(@RequestBody Venta obj) {
//        Venta venta = service.update(obj);
//        return new ResponseEntity<Venta>(venta, HttpStatus.OK);
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
        Venta venta = service.findById(id);
        if (venta == null) {
            ErrorMessage errorMessage = new ErrorMessage("404",
                    "Elemento no encontrado",
                    "0001",
                    "No existe el objeto en base de datos");
            return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Venta>(venta, HttpStatus.OK);
    }
}
