package com.example.ejerciciopract.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer id_producto;
    @Column(name = "stock")
    private Integer stock;
    @Column(name = "precio_unitario")
    private Double precio_unitario;
    @Column(name = "unidad")
    private String unidad;
    @Column(name = "iva")
    private Boolean iva;

    @ManyToOne
    @JoinColumn(name = "id_clasificacion", referencedColumnName = "id_clasificacion")
    private Clasificacion clasificacion;
    @ManyToOne
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id_proveedor")
    private Proveedor proveedor;
    
    @JsonIgnore
    @OneToMany(mappedBy = "producto")
    private List<Item_Factura> item_Facturas;
}