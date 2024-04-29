package com.chuvblocks.iswz2202_t1.service;

import com.chuvblocks.iswz2202_t1.model.Usuario;

public class TimingUsuarioServiceDecorator implements IUsuarioService {
    private final IUsuarioService delegate;

    public TimingUsuarioServiceDecorator(IUsuarioService delegate) {
        this.delegate = delegate;
    }

    @Override
    public Iterable<Usuario> getUsuarios() {
        long startTime = System.nanoTime();
        Iterable<Usuario> usuarios = delegate.getUsuarios();
        long endTime = System.nanoTime();
        System.out.println("Execution time in nanoseconds: " + (endTime - startTime));
        return usuarios;
    }

    @Override
    public Usuario createUsuario(Usuario usuario) {
        long startTime = System.nanoTime();
        Usuario result = delegate.createUsuario(usuario);
        long endTime = System.nanoTime();
        System.out.println("Execution time in nanoseconds: " + (endTime - startTime));
        return result;
    }

    @Override
    public Usuario getUsuarioById(long id) {
        long startTime = System.nanoTime();
        Usuario result = delegate.getUsuarioById(id);
        long endTime = System.nanoTime();
        System.out.println("Execution time in nanoseconds: " + (endTime - startTime));
        return result;
    }

    @Override
    public Usuario deleteUsuarioById(long id) {
        long startTime = System.nanoTime();
        Usuario result = delegate.deleteUsuarioById(id);
        long endTime = System.nanoTime();
        System.out.println("Execution time in nanoseconds: " + (endTime - startTime));
        return result;
    }

    @Override
    public Usuario updateUsuario(long id, Usuario usuario) {
        long startTime = System.nanoTime();
        Usuario result = delegate.updateUsuario(id, usuario);
        long endTime = System.nanoTime();
        System.out.println("Execution time in nanoseconds: " + (endTime - startTime));
        return result;
    }
}