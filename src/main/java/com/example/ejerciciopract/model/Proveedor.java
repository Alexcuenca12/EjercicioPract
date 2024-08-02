package com.example.ejerciciopract.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private Integer id_proveedor;
    @Column(name = "ruc")
    private String ruc;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "pais")
    private String pais;
    @Column(name = "correo")
    private String correo;
    @Column(name = "moneda")
    private String moneda;

    @JsonIgnore
    @OneToMany(mappedBy = "proveedor")
    private List<Producto> productos;
}
