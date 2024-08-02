package com.example.ejerciciopract.Services;

import com.example.ejerciciopract.model.Clasificacion;
import com.example.ejerciciopract.repository.IClasificacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ClasificacionServiceImpl extends GenericServiceImpl<Clasificacion,Long> implements IGenericService<Clasificacion,Long> {

    @Autowired
    private IClasificacion crudRepository;

    @Override
    public CrudRepository<Clasificacion, Long> getDao() {
        return crudRepository;
    }
}
