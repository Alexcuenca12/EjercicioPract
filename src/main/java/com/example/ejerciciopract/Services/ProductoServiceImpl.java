package com.example.ejerciciopract.Services;

import com.example.ejerciciopract.model.Producto;
import com.example.ejerciciopract.repository.IProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl extends GenericServiceImpl<Producto,Long>implements IGenericService<Producto,Long> {

    @Autowired
    IProducto productoRepository;

    @Override
    public CrudRepository<Producto, Long> getDao() {
        return productoRepository;
    }
}
