package com.example.ejerciciopract.Services;

import com.example.ejerciciopract.model.Rol;
import com.example.ejerciciopract.repository.IRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class RolServiceImpl extends GenericServiceImpl <Rol,Long> implements IRolService {

    @Autowired
    private IRol rolRepository;

    @Override
    public CrudRepository<Rol, Long> getDao() {
        return rolRepository;
    }


    @Override
    public boolean existsByRol(String rol) {
        return rolRepository.existsByRol(rol);
    }

    @Override
    public boolean existsByEstado(Boolean estado) {
        return rolRepository.existsByEstado(estado);
    }
}
