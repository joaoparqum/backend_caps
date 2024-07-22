package com.api.capssaude.controller;

import com.api.capssaude.dto.ProfDTO;
import com.api.capssaude.model.Profissional;
import com.api.capssaude.service.ProfissionalService;
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
@RequestMapping("/caps/profissional")
public class ProfissionalController {

    final ProfissionalService profService;

    public ProfissionalController(ProfissionalService profService) {
        this.profService = profService;
    }

    @PostMapping
    public ResponseEntity<Object> saveProf(@RequestBody @Valid ProfDTO profDto){
        Profissional profissional = new Profissional();
        BeanUtils.copyProperties(profDto, profissional);
        return ResponseEntity.status(HttpStatus.CREATED).body(profService.save(profissional));
    }

    @GetMapping
    public ResponseEntity<List<Profissional>> getAllProf(){
        return ResponseEntity.status(HttpStatus.CREATED).body(profService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneProf(@PathVariable(value = "id") UUID id){
        Optional<Profissional> profissional = profService.findById(id);
        if (!profissional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Profissonal não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(profissional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProf(@PathVariable(value = "id") UUID id){
        Optional<Profissional> profOptional = profService.findById(id);
        if (!profOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Profissonal não encontrado!");
        }
        profService.delete(profOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Profissonal deletado com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProf(@PathVariable(value = "id") UUID id,
                                                   @RequestBody @Valid ProfDTO profDto){
        Optional<Profissional> profOptional = profService.findById(id);
        if (!profOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Profissonal não encontrado!");
        }
        Profissional profissional = new Profissional();
        BeanUtils.copyProperties(profDto, profissional);
        profissional.setId(profOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(profService.save(profissional));
    }
}
