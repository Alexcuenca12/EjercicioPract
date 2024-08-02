package com.example.ejerciciopract.controller;

import com.example.ejerciciopract.Services.RolServiceImpl;
import com.example.ejerciciopract.model.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rol")
@CrossOrigin(origins = {"*"})

public class RolController {

    @Autowired
    RolServiceImpl rolService;

    @GetMapping("/get")
    public ResponseEntity<List<Rol>> list() {
        return new ResponseEntity<>(rolService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<Rol> create(@RequestBody Rol a) {
        return new ResponseEntity<>(rolService.save(a), HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Rol> update(@PathVariable Long id, @RequestBody Rol a) {
        Rol rol = rolService.findById(id);
        if (rol != null) {
            try {
                rol.setId_rol(a.getId_rol());
                rol.setRol(a.getRol());
                rol.setEstado(a.getEstado());

                return new ResponseEntity<>(rolService.save(rol), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Rol> delete(@PathVariable Long id) {
        rolService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
