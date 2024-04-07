package com.chuvblocks.iswz2202_t1.service;

import com.chuvblocks.iswz2202_t1.model.Usuario;

public interface IUsuarioService {
    Iterable<Usuario> getUsuarios();
    Usuario createUsuario(Usuario usuario);
    Usuario getUsuarioById(long id);
    Usuario deleteUsuarioById(long id);
    Usuario updateUsuario(long id, Usuario usuario);
}
