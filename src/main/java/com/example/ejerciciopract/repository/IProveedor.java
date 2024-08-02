package com.example.ejerciciopract.repository;

import com.example.ejerciciopract.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProveedor extends JpaRepository<Proveedor, Long> {
}
