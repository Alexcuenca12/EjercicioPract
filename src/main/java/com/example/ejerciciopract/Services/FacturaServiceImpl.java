package com.example.ejerciciopract.Services;

import com.example.ejerciciopract.model.Factura;
import com.example.ejerciciopract.repository.IFactura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class FacturaServiceImpl extends GenericServiceImpl<Factura,Long> implements IGenericService<Factura,Long> {
    @Autowired
    IFactura facturaRepository;
    @Override
    public CrudRepository<Factura, Long> getDao() {
        return facturaRepository;
    }
}
