package com.example.ejerciciopract.Services;

import com.example.ejerciciopract.model.Tipo_Pago;
import com.example.ejerciciopract.repository.ITipo_Pago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class Tipo_PagoServiceImpl extends GenericServiceImpl<Tipo_Pago,Long> implements IGenericService<Tipo_Pago,Long> {
    @Autowired
    ITipo_Pago  tipoPagoRepository;

    @Override
    public CrudRepository<Tipo_Pago, Long> getDao() {
        return tipoPagoRepository;
    }
}
