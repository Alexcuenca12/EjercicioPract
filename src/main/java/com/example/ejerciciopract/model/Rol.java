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
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Integer id_rol;
    @Column(name = "rol")
    private String rol;
    @Column(name = "estado")
    private Boolean estado;

    @JsonIgnore
    @OneToMany(mappedBy = "roles")
    private List<Roles_Usuarios> roles_usuarios;

    @JsonIgnore
    @OneToMany(mappedBy = "roles")
    private List<Competencias_Roles> competencias_roles;

}
