package com.example.ejerciciopract.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Item_Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item_factura")
    private Integer id_item_factura;
    @Column(name = "cantidad")
    private String cantidad;
    @Column(name = "precio")
    private Double precio;
    @Column(name = "subtotal")
    private Double subtotal;

    @ManyToOne
    @JoinColumn(name = "id_factura", referencedColumnName = "id_factura")
    private Factura factura;

    @ManyToOne
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    private Producto producto;
}
