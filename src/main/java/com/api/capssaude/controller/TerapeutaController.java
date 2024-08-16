package com.api.capssaude.controller;

import com.api.capssaude.dto.TerapeutaDTO;
import com.api.capssaude.dto.UsuarioDTO;
import com.api.capssaude.interfaces.ITerapeutaController;
import com.api.capssaude.model.TerapeutaOcupacional;
import com.api.capssaude.model.Usuario;
import com.api.capssaude.service.TerapeutaOcupacionalService;
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
@RequestMapping("/caps/terapeuta")
public class TerapeutaController implements ITerapeutaController {

    final TerapeutaOcupacionalService terapeutaService;

    public TerapeutaController(TerapeutaOcupacionalService terapeutaService) {
        this.terapeutaService = terapeutaService;
    }

    @Override
    @PostMapping
    public ResponseEntity<Object> saveTerapeuta(@RequestBody @Valid TerapeutaDTO terapeutaDto) {
        TerapeutaOcupacional terapeutaOcupacional = new TerapeutaOcupacional();
        BeanUtils.copyProperties(terapeutaDto, terapeutaOcupacional);
        return ResponseEntity.status(HttpStatus.CREATED).body(terapeutaService.save(terapeutaOcupacional));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<TerapeutaOcupacional>> getAllTerapeuta(){
        return ResponseEntity.status(HttpStatus.CREATED).body(terapeutaService.findAll());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneTerapeuta(@PathVariable(value = "id") UUID id){
        Optional<TerapeutaOcupacional> terapeutaOcupacional = terapeutaService.findById(id);
        if (!terapeutaOcupacional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Terapeuta Ocupacional não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(terapeutaOcupacional.get());
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTerapeuta(@PathVariable(value = "id") UUID id){
        Optional<TerapeutaOcupacional> terapeutaOptional = terapeutaService.findById(id);
        if (!terapeutaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Terapeuta Ocupacional não encontrado!");
        }
        terapeutaService.delete(terapeutaOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Terapeuta Ocupacional deletado com sucesso!");
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTerapeuta(@PathVariable(value = "id") UUID id,
                                                @RequestBody @Valid TerapeutaDTO terapeutaDto) {
        Optional<TerapeutaOcupacional> terapeutaOptional = terapeutaService.findById(id);
        if (!terapeutaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Terapeuta Ocupacional não encontrado!");
        }
        TerapeutaOcupacional terapeutaOcupacional = new TerapeutaOcupacional();
        BeanUtils.copyProperties(terapeutaDto, terapeutaOcupacional);
        terapeutaOcupacional.setId(terapeutaOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(terapeutaService.save(terapeutaOcupacional));
    }
}
