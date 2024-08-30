package com.api.capssaude.controller;

import com.api.capssaude.dto.MedicoDTO;
import com.api.capssaude.interfaces.IMedicoControl;
import com.api.capssaude.model.Medico;
import com.api.capssaude.service.MedicoService;
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
@RequestMapping("/caps/medico")
public class MedicoController implements IMedicoControl {

    final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @Override
    @PostMapping
    public ResponseEntity<Object> saveProf(@RequestBody @Valid MedicoDTO medicoDto){
        Medico medico = new Medico();
        BeanUtils.copyProperties(medicoDto, medico);
        return ResponseEntity.status(HttpStatus.CREATED).body(medicoService.save(medico));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Medico>> getAllProf(){
        return ResponseEntity.status(HttpStatus.CREATED).body(medicoService.findAll());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneProf(@PathVariable(value = "id") UUID id){
        Optional<Medico> profissional = medicoService.findById(id);
        if (!profissional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Profissonal não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(profissional.get());
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProf(@PathVariable(value = "id") UUID id){
        Optional<Medico> profOptional = medicoService.findById(id);
        if (!profOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Profissonal não encontrado!");
        }
        medicoService.delete(profOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Profissonal deletado com sucesso!");
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProf(@PathVariable(value = "id") UUID id,
                                                   @RequestBody @Valid MedicoDTO medicoDto){
        Optional<Medico> profOptional = medicoService.findById(id);
        if (!profOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Profissonal não encontrado!");
        }
        Medico medico = new Medico();
        BeanUtils.copyProperties(medicoDto, medico);
        medico.setId(profOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(medicoService.save(medico));
    }
}
