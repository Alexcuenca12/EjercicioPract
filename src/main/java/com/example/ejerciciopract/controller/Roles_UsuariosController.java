package com.example.ejerciciopract.controller;

import com.example.ejerciciopract.Services.Roles_UsuarioServiceImpl;
import com.example.ejerciciopract.model.Roles_Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rol_usuarios")
@CrossOrigin(origins = {"*"})
public class Roles_UsuariosController {


    @Autowired
    Roles_UsuarioServiceImpl rolService;

    @GetMapping("/get")
    public ResponseEntity<List<Roles_Usuarios>> list() {
        return new ResponseEntity<>(rolService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<Roles_Usuarios> create(@RequestBody Roles_Usuarios a) {
        return new ResponseEntity<>(rolService.save(a), HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Roles_Usuarios> update(@PathVariable Long id, @RequestBody Roles_Usuarios a) {
        Roles_Usuarios rol = rolService.findById(id);
        if (rol != null) {
            try {
                rol.setId_rol_usuarios(a.getId_rol_usuarios());
                rol.setUsuarios(a.getUsuarios());
                rol.setRoles(a.getRoles());

                return new ResponseEntity<>(rolService.save(rol), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Roles_Usuarios> delete(@PathVariable Long id) {
        rolService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
