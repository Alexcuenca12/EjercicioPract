package com.example.ejerciciopract.controller;

import com.example.ejerciciopract.Services.UsuarioServiceImpl;
import com.example.ejerciciopract.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = {"*"})
public class UsuarioController {


    @Autowired
    UsuarioServiceImpl usuarioService;

    @GetMapping("/get")
    public ResponseEntity<List<Usuario>> list() {
        return new ResponseEntity<>(usuarioService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<Usuario> create(@RequestBody Usuario a) {
        return new ResponseEntity<>(usuarioService.save(a), HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario a) {
        Usuario usuario = usuarioService.findById(id);
        if (usuario != null) {
            try {
                usuario.setId_usuario(a.getId_usuario());
                usuario.setUser(a.getUser());
                usuario.setPassword(a.getPassword());
                usuario.setPersona(a.getPersona());
                usuario.setRoles_usuarios(a.getRoles_usuarios());
                return new ResponseEntity<>(usuarioService.save(usuario), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Usuario> delete(@PathVariable Long id) {
        usuarioService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
