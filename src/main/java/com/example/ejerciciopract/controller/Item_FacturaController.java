package com.example.ejerciciopract.controller;

import com.example.ejerciciopract.Services.Item_FacturaServiceImpl;
import com.example.ejerciciopract.model.Item_Factura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item_factura")
@CrossOrigin(origins = {"*"})
public class Item_FacturaController {
    @Autowired
    Item_FacturaServiceImpl item_facturaService;

    @GetMapping("/get")
    public ResponseEntity<List<Item_Factura>> list() {
        return new ResponseEntity<>(item_facturaService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<Item_Factura> create(@RequestBody Item_Factura a) {
        return new ResponseEntity<>(item_facturaService.save(a), HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Item_Factura> update(@PathVariable Long id, @RequestBody Item_Factura a) {
        Item_Factura factura = item_facturaService.findById(id);
        if (factura != null) {
            try {
                factura.setId_item_factura(a.getId_item_factura());
                factura.setFactura(a.getFactura());
                factura.setCantidad(a.getCantidad());
                factura.setPrecio(a.getPrecio());
                factura.setSubtotal(a.getSubtotal());
                factura.setProducto(a.getProducto());
                return new ResponseEntity<>(item_facturaService.save(factura), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Item_Factura> delete(@PathVariable Long id) {
        item_facturaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
