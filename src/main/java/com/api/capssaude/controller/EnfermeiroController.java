package com.api.capssaude.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.capssaude.dto.EnfermeiroDTO;
import com.api.capssaude.interfaces.IEnfermeiroControl;
import com.api.capssaude.model.Enfermeiro;
import com.api.capssaude.service.EnfermeiroService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/caps/enfermeiro")
public class EnfermeiroController implements IEnfermeiroControl{

    final EnfermeiroService enfermeiroService;

    public EnfermeiroController(EnfermeiroService enfermeiroService){
        this.enfermeiroService = enfermeiroService;
    }

    @Override
    @PostMapping
    public ResponseEntity<Object> saveEnfermeiro(@RequestBody @Valid EnfermeiroDTO enfermeiroDTO) throws Exception {
       
        Enfermeiro enfermeiro = new Enfermeiro();
        BeanUtils.copyProperties(enfermeiroDTO, enfermeiro);
        return ResponseEntity.status(HttpStatus.CREATED).body(enfermeiroService.save(enfermeiro));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Enfermeiro>> getAllEnfermeiro() {
      return ResponseEntity.status(HttpStatus.CREATED).body(enfermeiroService.findAll());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneEnfermeiro(@PathVariable(value = "id")UUID id) {
        Optional<Enfermeiro> enfermeiro = enfermeiroService.findById(id);
        if(!enfermeiro.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Enfermeiro não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(enfermeiro.get());
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEnfermeiro(@PathVariable(value = "id")UUID id) {
        Optional<Enfermeiro> enfermeiroOptional = enfermeiroService.findById(id);
        if(!enfermeiroOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Enfermeiro não encontrado!");
        }
        enfermeiroService.delete(enfermeiroOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Enfermeiro deletado com sucesso!");
        }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEnfermeiro(@RequestBody @Valid @PathVariable(value = "id")UUID id, @Valid EnfermeiroDTO enfermeiroDTO) {
       
        Optional<Enfermeiro> enfermeiroOptional = enfermeiroService.findById(id);
        if(!enfermeiroOptional.isPresent()){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Enfermeiro não encontrado"); 
        }
        
        Enfermeiro enfermeiro = new Enfermeiro();
        BeanUtils.copyProperties(enfermeiroDTO, enfermeiro);
        enfermeiro.setId(enfermeiroOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(enfermeiroService.save(enfermeiro));
    }

}