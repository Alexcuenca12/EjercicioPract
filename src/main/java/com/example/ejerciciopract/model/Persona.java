package com.example.ejerciciopract.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Integer id_persona;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "dni")
    private String dni;
    @Column(name = "celular")
    private String celular;
    @Column(name = "correo")
    private String correo;

    @JsonIgnore
    @OneToMany(mappedBy = "persona")
    private List<Factura> Facturas;

    @JsonIgnore
    @OneToMany(mappedBy = "persona")
    private List<Usuario> usuarios;
}