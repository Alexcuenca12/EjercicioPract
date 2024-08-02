package com.example.ejerciciopract.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Competencias_Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_competencia_rol")
    private Integer id_competencia_rol;


    @ManyToOne
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
    private Rol roles;

    @ManyToOne
    @JoinColumn(name = "id_competencias", referencedColumnName = "id_competencias")
    private Competencia competencia;
}
