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

    public Usuario save(Usuario usuario) throws Exception{
        //regra de negócio para verificar se usuário já existe no sistema
        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(usuario.getEmail());
        if (usuarioExistente.isPresent()) {
            throw new Exception("Usuário já existe com este e-mail!");
        }
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

    //método para procurar o usuário pelo nome
    public List<Usuario> findByNome(String nome) {
        return usuarioRepository.findByNome(nome);
    }

}
