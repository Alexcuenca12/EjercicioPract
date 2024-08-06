package com.example.ejerciciopract.repository;

import com.example.ejerciciopract.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRol extends JpaRepository<Rol, Long> {

    public Boolean findByRol (String rol);
    public Boolean findByEstado (String estado);
}
