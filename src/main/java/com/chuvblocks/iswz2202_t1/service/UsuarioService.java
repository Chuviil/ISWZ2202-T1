package com.chuvblocks.iswz2202_t1.service;

import com.chuvblocks.iswz2202_t1.model.Usuario;
import com.chuvblocks.iswz2202_t1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService implements IUsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public Iterable<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepository.save(new Usuario(usuario.getNombre()));
    }

    @Override
    @CacheEvict(cacheNames = "usuarios", key = "#id")
    public Usuario deleteUsuarioById(long id){
        Optional<Usuario> _usuario = usuarioRepository.findById(id);
        if(_usuario.isPresent()){
            usuarioRepository.deleteById(id);
            return _usuario.get();
        }
        return null;
    }
    @Override
    @Cacheable(cacheNames = "usuarios", key = "#id")
    public Usuario getUsuarioById(long id) {
        Optional<Usuario> _usuario = usuarioRepository.findById(id);
        return _usuario.orElseGet(() -> null);
    }
}
