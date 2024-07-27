package com.api.capssaude.controller;

import com.api.capssaude.dto.PacienteDTO;
import com.api.capssaude.model.Paciente;
import com.api.capssaude.model.Usuario;
import com.api.capssaude.service.PacienteService;
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
@RequestMapping("/caps/paciente")
public class PacienteController {

    final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public ResponseEntity<Object> savePaciente(@RequestBody @Valid PacienteDTO pacienteDTO) {
        Paciente paciente = new Paciente();
        BeanUtils.copyProperties(pacienteDTO, paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteService.save(paciente));
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> getAllPaciente(){
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOnePaciente(@PathVariable(value = "id") UUID id){
        Optional<Paciente> paciente = pacienteService.findById(id);
        if (!paciente.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(paciente.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePaciente(@PathVariable(value = "id") UUID id){
        Optional<Paciente> pacienteOptional = pacienteService.findById(id);
        if (!pacienteOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente não encontrado!");
        }
        pacienteService.delete(pacienteOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Paciente deletado com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePaciente(@PathVariable(value = "id") UUID id,
                                                @RequestBody @Valid PacienteDTO pacienteDTO) {
        Optional<Paciente> pacienteOptional = pacienteService.findById(id);
        if (!pacienteOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente não encontrado!");
        }
        Paciente paciente = new Paciente();
        BeanUtils.copyProperties(pacienteDTO, paciente);
        paciente.setId(pacienteOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(pacienteService.save(paciente));
    }

}
