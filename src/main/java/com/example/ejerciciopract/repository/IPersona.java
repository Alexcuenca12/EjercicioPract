package com.example.ejerciciopract.repository;

import com.example.ejerciciopract.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersona extends JpaRepository<Persona, Long> {

 Boolean existsByDni(String dni);

 Persona findByDni(String dni);
}
