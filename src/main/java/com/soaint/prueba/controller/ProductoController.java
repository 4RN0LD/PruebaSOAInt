package com.soaint.prueba.controller;

import com.soaint.prueba.dto.ErrorMessage;
import com.soaint.prueba.model.Producto;
import com.soaint.prueba.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private IService<Producto> service;

    
    @GetMapping
    public ResponseEntity<List<Producto>> listar() {
        List<Producto> productos = service.findAll();
        return new ResponseEntity(productos, HttpStatus.OK);
    }

    
    @PostMapping
    public Object registrar(@RequestBody Producto obj) {
        Producto producto = service.save(obj);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(producto.getIdProducto())
                .toUri();
        return ResponseEntity.created(location);
    }

    
    @PutMapping
    public ResponseEntity<Producto> modificar(@RequestBody Producto obj) {
        Producto producto = service.update(obj);
        return new ResponseEntity<Producto>(producto, HttpStatus.OK);
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
        service.delete(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id) {
        Producto producto = service.findById(id);
        if (producto == null) {
            ErrorMessage errorMessage = new ErrorMessage("404",
                    "Elemento no encontrado",
                    "0001",
                    "No existe el objeto en base de datos");
            return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Producto>(producto, HttpStatus.OK);
    }
}
