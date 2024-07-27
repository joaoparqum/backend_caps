package com.api.capssaude.service;

import com.api.capssaude.interfaces.IUsuarioService;
import com.api.capssaude.model.Profissional;
import com.api.capssaude.model.Usuario;
import com.api.capssaude.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public Usuario save(Usuario usuario) throws Exception{
        //regra de negócio para verificar se usuário já existe no sistema
        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(usuario.getEmail());
        if (usuarioExistente.isPresent()) {
            throw new Exception("Usuário já existe com este e-mail!");
        }
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> findById(UUID id){
        return usuarioRepository.findById(id);
    }

    @Override
    public void delete(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }

    //método para procurar o usuário pelo nome
    @Override
    public List<Usuario> findByNome(String nome) {
        return usuarioRepository.findByNome(nome);
    }

}
