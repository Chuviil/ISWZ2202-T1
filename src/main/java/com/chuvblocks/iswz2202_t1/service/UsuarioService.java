package com.chuvblocks.iswz2202_t1.service;

import com.chuvblocks.iswz2202_t1.model.Usuario;
import com.chuvblocks.iswz2202_t1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
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
    @Cacheable(cacheNames = "usuarios", key = "#id")
    public Usuario getUsuarioById(long id) {
        Optional<Usuario> _usuario = usuarioRepository.findById(id);
        return _usuario.orElseGet(() -> null);
    }

    @Override
    @CachePut(cacheNames = "usuarios", key = "#id")
    public Usuario updateUsuario(long id, Usuario usuario) {
        Optional<Usuario> _usuario = usuarioRepository.findById(id);
        if (_usuario.isPresent()) {
            Usuario _usuarioData = _usuario.get();
            _usuarioData.setNombre(usuario.getNombre());
            return usuarioRepository.save(_usuarioData);
        }
        return null;
    }
}
