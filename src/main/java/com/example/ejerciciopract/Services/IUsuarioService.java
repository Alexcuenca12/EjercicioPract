package com.example.ejerciciopract.Services;

import com.example.ejerciciopract.model.Usuario;

public interface IUsuarioService extends IGenericService<Usuario,Long> {

public Usuario siExiste(String user, String password);


}
