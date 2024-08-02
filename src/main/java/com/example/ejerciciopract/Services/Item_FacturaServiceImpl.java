package com.example.ejerciciopract.Services;

import com.example.ejerciciopract.model.Item_Factura;
import com.example.ejerciciopract.repository.IItem_factura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class Item_FacturaServiceImpl extends GenericServiceImpl<Item_Factura, Long> implements IGenericService<Item_Factura, Long> {
    @Autowired
    IItem_factura iItem_factura;
    @Override
    public CrudRepository<Item_Factura, Long> getDao() {
        return iItem_factura;
    }
}
