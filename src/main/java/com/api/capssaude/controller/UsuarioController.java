package com.api.capssaude.controller;

import com.api.capssaude.dto.ProfDTO;
import com.api.capssaude.dto.UsuarioDTO;
import com.api.capssaude.model.Profissional;
import com.api.capssaude.model.Usuario;
import com.api.capssaude.service.ProfissionalService;
import com.api.capssaude.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/caps/usuario")
public class UsuarioController {

    final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Object> saveUsuaro(@RequestBody @Valid UsuarioDTO usuDto){
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuDto, usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuario(){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneUsuario(@PathVariable(value = "id") UUID id){
        Optional<Usuario> usuario = usuarioService.findById(id);
        if (!usuario.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(usuario.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUsuario(@PathVariable(value = "id") UUID id){
        Optional<Usuario> usuarioOptional = usuarioService.findById(id);
        if (!usuarioOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado!");
        }
        usuarioService.delete(usuarioOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Usuario deletado com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUsuario(@PathVariable(value = "id") UUID id,
                                             @RequestBody @Valid UsuarioDTO usuDto){
        Optional<Usuario> usuarioOptional = usuarioService.findById(id);
        if (!usuarioOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado!");
        }
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuDto, usuario);
        usuario.setId(usuarioOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.save(usuario));
    }
}
