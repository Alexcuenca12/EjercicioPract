package com.example.ejerciciopract.Services;

import com.example.ejerciciopract.model.Roles_Usuarios;
import com.example.ejerciciopract.repository.IRoles_Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class Roles_UsuarioServiceImpl extends GenericServiceImpl<Roles_Usuarios,Long> implements IGenericService<Roles_Usuarios,Long> {
    @Autowired
    IRoles_Usuarios roles_usuariosRepository;

    @Override
    public CrudRepository<Roles_Usuarios, Long> getDao() {
        return roles_usuariosRepository;
    }
}
