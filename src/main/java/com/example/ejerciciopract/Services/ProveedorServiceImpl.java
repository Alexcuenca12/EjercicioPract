package com.example.ejerciciopract.Services;

import com.example.ejerciciopract.model.Proveedor;
import com.example.ejerciciopract.repository.IProveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ProveedorServiceImpl extends GenericServiceImpl<Proveedor,Long> implements IGenericService<Proveedor,Long> {
    @Autowired
    IProveedor proveedorRepository;

    @Override
    public CrudRepository<Proveedor, Long> getDao() {
        return proveedorRepository;
    }
}
