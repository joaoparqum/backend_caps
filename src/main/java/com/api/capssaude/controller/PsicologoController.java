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

import com.api.capssaude.dto.PsicologoDTO;
import com.api.capssaude.interfaces.IPsicologoControl;
import com.api.capssaude.model.Psicologo;
import com.api.capssaude.service.PsicologoService;

import jakarta.validation.Valid;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/caps/psicologo")
public class PsicologoController implements IPsicologoControl {

    final PsicologoService psicologoService;

    public PsicologoController(PsicologoService psicologoService){
        this.psicologoService = psicologoService;
    }

    @Override
    @PostMapping
    public ResponseEntity<Object> savePsicologo(@RequestBody @Valid PsicologoDTO psicologoDTO) throws Exception{
    
        Psicologo psicologo = new Psicologo();
        BeanUtils.copyProperties(psicologoDTO, psicologo);
        return ResponseEntity.status(HttpStatus.CREATED).body(psicologoService.save(psicologo));
    }

    @Override
     @GetMapping
    public ResponseEntity<List<Psicologo>> getAllPsicologo() {
        return ResponseEntity.status(HttpStatus.CREATED).body(psicologoService.findAll());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOnePsicologo(@PathVariable(value = "id")UUID id) {
         Optional<Psicologo> psicologo = psicologoService.findById(id);
        if (!psicologo.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Psicologo não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(psicologo.get());
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePsicologo(@PathVariable(value = "id") UUID id) {
        Optional<Psicologo> psicologoOptional = psicologoService.findById(id);
        if (!psicologoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Psicologo não encontrado!");
        }
        psicologoService.delete(psicologoOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Psicologo deletado com sucesso!");
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePsicologo(@PathVariable(value = "id") UUID id, @RequestBody @Valid PsicologoDTO psicologoDTO) {
        Optional<Psicologo> psicologoOptional = psicologoService.findById(id);
        if (!psicologoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Psicologo não encontrado!");
        }
        Psicologo psicologo = new Psicologo();
        BeanUtils.copyProperties(psicologoDTO, psicologo);
        psicologo.setId(psicologoOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(psicologoService.save(psicologo));
    }
    
}
