package com.example.ejerciciopract.repository;

import com.example.ejerciciopract.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;

public interface IUsuario extends JpaRepository<Usuario, Long>{

    @Query(value = "SELECT * " +
            "FROM usuario u " +
            "WHERE u.user = :user " +
            "and u.password = :password", nativeQuery = true)
    public Usuario siExiste(String user, String password);

}
