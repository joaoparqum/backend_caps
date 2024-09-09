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
import com.api.capssaude.dto.RelatorioMedicoDTO;
import com.api.capssaude.interfaces.IRelatorioMedicoControl;
import com.api.capssaude.model.RelatorioMedico;
import com.api.capssaude.service.RelatorioMedicoService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/caps/RelatorioMedico")
public class RelatorioMedicoController implements IRelatorioMedicoControl{

    final RelatorioMedicoService relatorioMedicoService; 

    public RelatorioMedicoController(RelatorioMedicoService relatorioMedicoService){
        this.relatorioMedicoService = relatorioMedicoService;
    }

    @Override
    @PostMapping
    public ResponseEntity<Object> saveRelatorioMedico(@RequestBody @Valid RelatorioMedicoDTO relatorioMedicoDTO) {
        RelatorioMedico relatorioMedico = new RelatorioMedico();
              BeanUtils.copyProperties(relatorioMedicoDTO, relatorioMedico);
        return ResponseEntity.status(HttpStatus.CREATED).body(relatorioMedicoService.save(relatorioMedico));     
    }

    @Override
    @GetMapping
    public ResponseEntity<List<RelatorioMedico>> getAllRelatorioMedico() {
        return ResponseEntity.status(HttpStatus.CREATED).body(relatorioMedicoService.findAll());

    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneRelatorioMedico(@PathVariable(value = "id") UUID id) {

        Optional<RelatorioMedico> relatorioMedico = relatorioMedicoService.findById(id);
        if (!relatorioMedico.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" Relatorio medico não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(relatorioMedico.get());

    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRelatorioMedico(@PathVariable(value = "id")UUID id) {
        Optional<RelatorioMedico> relatorioMedicoOptional = relatorioMedicoService.findById(id);
        if (!relatorioMedicoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Relatorio medico não encontrado!");
        }
        relatorioMedicoService.delete(relatorioMedicoOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Relatorio medico deletado com sucesso!");

    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateRelatorioMedico(@PathVariable(value = "id") UUID id,
                                                  @RequestBody @Valid RelatorioMedicoDTO relatorioMedicoDTO) {
         Optional<RelatorioMedico> relatorioMedicoOptional = relatorioMedicoService.findById(id);
        if (!relatorioMedicoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reltório médico não encontrado!");
        }
        RelatorioMedico relatorioMedico = new RelatorioMedico();
        BeanUtils.copyProperties(relatorioMedicoDTO, relatorioMedico);
        relatorioMedico.setId(relatorioMedicoOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(relatorioMedicoService.save(relatorioMedico));
                            
    }
    
}
