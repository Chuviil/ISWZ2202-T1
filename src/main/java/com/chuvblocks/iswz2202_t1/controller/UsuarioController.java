package com.chuvblocks.iswz2202_t1.controller;

import com.chuvblocks.iswz2202_t1.model.Usuario;
import com.chuvblocks.iswz2202_t1.repository.UsuarioRepository;
import com.chuvblocks.iswz2202_t1.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public ResponseEntity<Iterable<Usuario>> getAllUsuarios() {
        try {
            Iterable<Usuario> _usuarios = usuarioService.getUsuarios();
            return new ResponseEntity<>(_usuarios, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable long id) {
        try {
            Usuario _usuario = usuarioService.getUsuarioById(id);
            if (_usuario == null)
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(_usuario, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/usuarios")
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
        try {
            Usuario _usuario = usuarioService.createUsuario(usuario);
            return new ResponseEntity<>(_usuario, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> deleteUsuarioById(@PathVariable long id){
        try{
            Usuario _usuario=usuarioService.deleteUsuarioById(id);
            if(_usuario==null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(_usuario, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
