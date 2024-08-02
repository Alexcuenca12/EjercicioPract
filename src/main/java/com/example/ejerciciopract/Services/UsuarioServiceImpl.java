package com.example.ejerciciopract.Services;

import com.example.ejerciciopract.model.Usuario;
import com.example.ejerciciopract.repository.IUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl extends GenericServiceImpl<Usuario,Long> implements IGenericService<Usuario,Long> {
    @Autowired
    IUsuario usuarioRepository;
    @Override
    public CrudRepository<Usuario, Long> getDao() {
        return usuarioRepository;
    }
}
