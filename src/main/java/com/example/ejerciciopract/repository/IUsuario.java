package com.example.ejerciciopract.repository;

import com.example.ejerciciopract.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface IUsuario extends JpaRepository<Usuario, Long>{

}
