package com.api.capssaude.interfaces;

import com.api.capssaude.model.Paciente;
import com.api.capssaude.model.Usuario;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IUsuarioService {

    public Usuario save(Usuario usuario) throws Exception;
    public List<Usuario> findAll();
    public Optional<Usuario> findById(UUID id);
    public void delete(Usuario usuario);
    public List<Usuario> findByNome(String nome);

}
