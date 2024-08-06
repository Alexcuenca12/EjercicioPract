package com.example.ejerciciopract.Services;

import com.example.ejerciciopract.model.Rol;


public interface IRolService extends IGenericService<Rol,Long> {

    public Boolean findByRol (String rol);

    public Boolean findByEstado (String estado);

}