package com.example.ejerciciopract.repository;

import com.example.ejerciciopract.model.Competencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface ICompetencia extends JpaRepository<Competencia, Long> {
}
