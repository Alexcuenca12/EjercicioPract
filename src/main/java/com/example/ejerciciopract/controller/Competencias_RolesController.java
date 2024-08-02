package com.example.ejerciciopract.controller;

import com.example.ejerciciopract.Services.CompetenciaServiceImpl;
import com.example.ejerciciopract.Services.Competencia_RolesServiceImpl;
import com.example.ejerciciopract.model.Competencia;
import com.example.ejerciciopract.model.Competencias_Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/competencia_roles")
@CrossOrigin(origins = {"*"})
public class Competencias_RolesController {


    @Autowired
    Competencia_RolesServiceImpl competenciaService;

    @GetMapping("/get")
    public ResponseEntity<List<Competencias_Roles>> list() {
        return new ResponseEntity<>(competenciaService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<Competencias_Roles> create(@RequestBody Competencias_Roles a) {
        return new ResponseEntity<>(competenciaService.save(a), HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Competencias_Roles> update(@PathVariable Long id, @RequestBody Competencias_Roles a) {
        Competencias_Roles competencia = competenciaService.findById(id);
        if (competencia != null) {
            try {
                competencia.setId_competencia_rol(a.getId_competencia_rol());
                competencia.setCompetencia(a.getCompetencia());
                competencia.setRoles(a.getRoles());
                return new ResponseEntity<>(competenciaService.save(competencia), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Competencias_Roles> delete(@PathVariable Long id) {
        competenciaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
