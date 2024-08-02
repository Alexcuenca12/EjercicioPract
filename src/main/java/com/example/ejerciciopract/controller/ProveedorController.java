package com.example.ejerciciopract.controller;

import com.example.ejerciciopract.Services.ProveedorServiceImpl;
import com.example.ejerciciopract.model.Proveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proveedor")
@CrossOrigin(origins = {"*"})
public class ProveedorController {

    @Autowired
    ProveedorServiceImpl proveedorService;

    @GetMapping("/get")
    public ResponseEntity<List<Proveedor>> list() {
        return new ResponseEntity<>(proveedorService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<Proveedor> create(@RequestBody Proveedor a) {
        return new ResponseEntity<>(proveedorService.save(a), HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Proveedor> update(@PathVariable Long id, @RequestBody Proveedor a) {
        Proveedor proveedor = proveedorService.findById(id);
        if (proveedor != null) {
            try {
                proveedor.setId_proveedor(a.getId_proveedor());
                proveedor.setRuc(a.getRuc());
                proveedor.setTelefono(a.getTelefono());
                proveedor.setPais(a.getPais());
                proveedor.setCorreo(a.getCorreo());
                proveedor.setMoneda(a.getMoneda());

                return new ResponseEntity<>(proveedorService.save(proveedor), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Proveedor> delete(@PathVariable Long id) {
        proveedorService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
