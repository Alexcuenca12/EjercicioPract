package com.example.ejerciciopract.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Tipo_Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_pago")
    private Integer id_tipo_pago;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "descrip")
    private String descrip;

    @JsonIgnore
    @OneToMany(mappedBy = "tipo_Pago")
    private List<Factura> facturas;
}