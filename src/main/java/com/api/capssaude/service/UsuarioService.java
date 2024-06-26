package com.api.capssaude.service;

import com.api.capssaude.model.Profissional;
import com.api.capssaude.model.Usuario;
import com.api.capssaude.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario save(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> findById(UUID id){
        return usuarioRepository.findById(id);
    }

    public void delete(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }

}
