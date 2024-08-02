package com.example.ejerciciopract.controller;


import com.example.ejerciciopract.Services.ProductoServiceImpl;
import com.example.ejerciciopract.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = {"*"})
public class ProductoController {

    @Autowired
    ProductoServiceImpl productoService;

    @GetMapping("/get")
    public ResponseEntity<List<Producto>> list() {
        return new ResponseEntity<>(productoService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<Producto> create(@RequestBody Producto a) {
        return new ResponseEntity<>(productoService.save(a), HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Producto> update(@PathVariable Long id, @RequestBody Producto a) {
        Producto producto = productoService.findById(id);
        if (producto != null) {
            try {
                producto.setId_producto(a.getId_producto());
                producto.setStock(a.getStock());
                producto.setPrecio_unitario(a.getPrecio_unitario());
                producto.setUnidad(a.getUnidad());
                producto.setIva(a.getIva());
                producto.setClasificacion(a.getClasificacion());
                producto.setProveedor(a.getProveedor());

                return new ResponseEntity<>(productoService.save(producto), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Producto> delete(@PathVariable Long id) {
        productoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
