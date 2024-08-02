package com.example.ejerciciopract.controller;

import com.example.ejerciciopract.Services.FacturaServiceImpl;
import com.example.ejerciciopract.Services.FacturaServiceImpl;
import com.example.ejerciciopract.model.Factura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/factura")
@CrossOrigin(origins = {"*"})
public class FacturaController {

    @Autowired
    FacturaServiceImpl facturaService;

    @GetMapping("/get")
    public ResponseEntity<List<Factura>> list() {
        return new ResponseEntity<>(facturaService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<Factura> create(@RequestBody Factura a) {
        return new ResponseEntity<>(facturaService.save(a), HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Factura> update(@PathVariable Long id, @RequestBody Factura a) {
        Factura factura = facturaService.findById(id);
        if (factura != null) {
            try {
                factura.setId_factura(a.getId_factura());
                factura.setRuc(a.getRuc());
                factura.setDescuento(a.getDescuento());
                factura.setFecha(a.getFecha());
                factura.setTotal(a.getTotal());
                factura.setItem_Facturas(a.getItem_Facturas());

                return new ResponseEntity<>(facturaService.save(factura), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Factura> delete(@PathVariable Long id) {
        facturaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
