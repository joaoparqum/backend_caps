package com.api.capssaude.interfaces;

import com.api.capssaude.dto.UsuarioDTO;
import com.api.capssaude.model.Usuario;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

public interface IUsuarioControl {

    public ResponseEntity<Object> saveUsuario(@RequestBody @Valid UsuarioDTO usuDto) throws Exception;
    public ResponseEntity<Object> getUsuarioByNome(@PathVariable(value = "nome") String nome);
    public ResponseEntity<List<Usuario>> getAllUsuario();
    public ResponseEntity<Object> getOneUsuario(@PathVariable(value = "id") UUID id);
    public ResponseEntity<Object> deleteUsuario(@PathVariable(value = "id") UUID id);
    public ResponseEntity<Object> updateUsuario(@PathVariable(value = "id") UUID id,
    @RequestBody @Valid UsuarioDTO usuDto);

}
