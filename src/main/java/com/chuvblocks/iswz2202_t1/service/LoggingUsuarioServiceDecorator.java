package com.chuvblocks.iswz2202_t1.service;

import com.chuvblocks.iswz2202_t1.model.Usuario;

public class LoggingUsuarioServiceDecorator implements IUsuarioService {
    private final IUsuarioService wrapper;

    public LoggingUsuarioServiceDecorator(IUsuarioService wrapper) {
        this.wrapper = wrapper;
    }

    @Override
    public Iterable<Usuario> getUsuarios() {
        System.out.println("Getting all usuarios");
        return wrapper.getUsuarios();
    }

    @Override
    public Usuario createUsuario(Usuario usuario) {
        System.out.println("Creating usuario: " + usuario.getNombre());
        return wrapper.createUsuario(usuario);
    }

    @Override
    public Usuario deleteUsuarioById(long id) {
        System.out.println("Deleting usuario with id: " + id);
        return wrapper.deleteUsuarioById(id);
    }

    @Override
    public Usuario getUsuarioById(long id) {
        System.out.println("Getting usuario with id: " + id);
        return wrapper.getUsuarioById(id);
    }

    @Override
    public Usuario updateUsuario(long id, Usuario usuario) {
        System.out.println("Updating usuario with id: " + id);
        return wrapper.updateUsuario(id, usuario);
    }
}