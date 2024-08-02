package com.example.ejerciciopract.repository;

import com.example.ejerciciopract.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProducto extends JpaRepository<Producto, Long>{
}
