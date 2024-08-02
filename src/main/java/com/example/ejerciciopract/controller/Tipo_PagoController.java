package com.example.ejerciciopract.controller;

import com.example.ejerciciopract.Services.Tipo_PagoServiceImpl;
import com.example.ejerciciopract.model.Tipo_Pago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipo_pago")
@CrossOrigin(origins = {"*"})
public class Tipo_PagoController {

    @Autowired
    Tipo_PagoServiceImpl tipo_pagoService;

    @GetMapping("/get")
    public ResponseEntity<List<Tipo_Pago>> list() {
        return new ResponseEntity<>(tipo_pagoService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<Tipo_Pago> create(@RequestBody Tipo_Pago a) {
        return new ResponseEntity<>(tipo_pagoService.save(a), HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Tipo_Pago> update(@PathVariable Long id, @RequestBody Tipo_Pago a) {
        Tipo_Pago tipo_Pago = tipo_pagoService.findById(id);
        if (tipo_Pago != null) {
            try {
                tipo_Pago.setId_tipo_pago(a.getId_tipo_pago());
                tipo_Pago.setTipo(a.getTipo());
                tipo_Pago.setDescrip(a.getDescrip());
                return new ResponseEntity<>(tipo_pagoService.save(tipo_Pago), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Tipo_Pago> delete(@PathVariable Long id) {
        tipo_pagoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
