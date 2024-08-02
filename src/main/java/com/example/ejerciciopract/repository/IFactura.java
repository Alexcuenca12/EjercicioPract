package com.example.ejerciciopract.repository;

import com.example.ejerciciopract.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFactura extends JpaRepository<Factura, Long> {
}
