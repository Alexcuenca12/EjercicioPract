package com.example.ejerciciopract.controller;

import com.example.ejerciciopract.Services.PersonaServiceImpl;
import com.example.ejerciciopract.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
@CrossOrigin(origins = {"*"})
public class PersonaController {

    @Autowired
    PersonaServiceImpl personaService;

    @GetMapping("/get")
    public ResponseEntity<List<Persona>> list() {
        return new ResponseEntity<>(personaService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<Persona> create(@RequestBody Persona a) {
        // Verificar si el DNI ya existe
        if (personaService.findBydni(a.getDni())) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        try {
            return new ResponseEntity<>(personaService.save(a), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método para actualizar por ID
    @PutMapping("/put/{id}")
    public ResponseEntity<Persona> update(@PathVariable Long id, @RequestBody Persona a) {
        Persona persona = personaService.findById(id);
        if (persona != null) {
            if (!persona.getDni().equals(a.getDni()) && personaService.findBydni(a.getDni())) {
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
            try {
                persona.setId_persona(a.getId_persona());
                persona.setNombre(a.getNombre());
                persona.setApellido(a.getApellido());
                persona.setDni(a.getDni());
                persona.setCelular(a.getCelular());
                persona.setCorreo(a.getCorreo());

                return new ResponseEntity<>(personaService.save(persona), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Persona> delete(@PathVariable Long id) {
        personaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/findByDni/{dni}")
    public ResponseEntity<Boolean> findByDni(@PathVariable String dni) {
        boolean exists = personaService.findBydni(dni);
        return new ResponseEntity<>(exists, HttpStatus.OK);
    }

    @GetMapping("/nombreCompleto/{dni}")
    public ResponseEntity<String> obtenerNombreCompletoPorDni(@PathVariable String dni) {
        String nombreCompleto = personaService.buscarNombreCompletoPorDni(dni);
        if (nombreCompleto != null) {
            return new ResponseEntity<>(nombreCompleto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
