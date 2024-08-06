package com.example.ejerciciopract.Services;

import com.example.ejerciciopract.model.Rol;


public interface IRolService extends IGenericService<Rol,Long> {

    boolean existsByRol (String rol);
    boolean existsByEstado(Boolean estado);


}