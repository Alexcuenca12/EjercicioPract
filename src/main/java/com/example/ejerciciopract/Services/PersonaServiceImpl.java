package com.example.ejerciciopract.Services;

import com.example.ejerciciopract.model.Persona;
import com.example.ejerciciopract.repository.IPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl extends GenericServiceImpl<Persona,Long> implements IGenericService<Persona,Long> {
    @Autowired
    IPersona personaRepository;

    @Override
    public CrudRepository<Persona, Long> getDao() {
        return personaRepository;
    }
}
