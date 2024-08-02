package com.example.ejerciciopract.controller;

import com.example.ejerciciopract.Services.ClasificacionServiceImpl;
import com.example.ejerciciopract.model.Clasificacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clasificacion")
@CrossOrigin(origins = {"*"})
public class ClasificacionController {
    @Autowired
    ClasificacionServiceImpl clasificacionService;

    @GetMapping("/get")
    public ResponseEntity<List<Clasificacion>> list() {
        return new ResponseEntity<>(clasificacionService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<Clasificacion> create(@RequestBody Clasificacion a) {
        return new ResponseEntity<>(clasificacionService.save(a), HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Clasificacion> update(@PathVariable Long id, @RequestBody Clasificacion a) {
        Clasificacion clasificacion = clasificacionService.findById(id);
        if (clasificacion != null) {
            try {
                clasificacion.setId_clasificacion(a.getId_clasificacion());
                clasificacion.setGrupo(a.getGrupo());

                return new ResponseEntity<>(clasificacionService.save(clasificacion), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Clasificacion> delete(@PathVariable Long id) {
        clasificacionService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
