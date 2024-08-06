package com.example.ejerciciopract.Services;

import com.example.ejerciciopract.model.Persona;

public interface IPersonaService extends IGenericService<Persona,Long> {

    Boolean existePersona(String dni);
}
