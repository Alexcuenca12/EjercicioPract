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


    public Boolean findBydni (String dni){
        return personaRepository.existsByDni(dni);
    }

    public String buscarNombreCompletoPorDni(String dni) {
        Persona persona = personaRepository.findByDni(dni);
        if (persona != null) {
            return persona.getApellido() + " " + persona.getNombre();
        }
        return null;
    }



    @Override
    public CrudRepository<Persona, Long> getDao() {
        return personaRepository;
    }
}
