package com.example.ejerciciopract.controller;

import com.example.ejerciciopract.Services.CompetenciaServiceImpl;
import com.example.ejerciciopract.model.Competencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/competencia")
@CrossOrigin(origins = {"*"})
public class CompetenciaController {

    @Autowired
    CompetenciaServiceImpl competenciaService;

    @GetMapping("/get")
    public ResponseEntity<List<Competencia>> list() {
        return new ResponseEntity<>(competenciaService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<Competencia> create(@RequestBody Competencia a) {
        return new ResponseEntity<>(competenciaService.save(a), HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Competencia> update(@PathVariable Long id, @RequestBody Competencia a) {
        Competencia competencia = competenciaService.findById(id);
        if (competencia != null) {
            try {
                competencia.setId_competencias(a.getId_competencias());
                competencia.setNombre(a.getNombre());
                competencia.setDescripcion(a.getDescripcion());
                return new ResponseEntity<>(competenciaService.save(competencia), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Competencia> delete(@PathVariable Long id) {
        competenciaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
