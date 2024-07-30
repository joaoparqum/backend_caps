package com.api.capssaude.controller;

import com.api.capssaude.interfaces.IConsultaControl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.capssaude.dto.ConsultaDTO;
import com.api.capssaude.model.Consulta;
import com.api.capssaude.service.ConsultaService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/caps/consulta")

public class ConsultaController implements IConsultaControl{
    
    final ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService){
        this.consultaService =  consultaService;
    }

    @Override
    public ResponseEntity<Object> saveConsulta(@Valid ConsultaDTO consultaDTO) throws Exception {
        Consulta consulta = new Consulta();
        BeanUtils.copyProperties(consultaDTO, consulta);
        return ResponseEntity.status(HttpStatus.CREATED).body(consultaService.save(consulta));
    }

    @Override
    public ResponseEntity<List<Consulta>> getAllConsulta() {
        return ResponseEntity.status(HttpStatus.CREATED).body(consultaService.findAll());
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Object> getOneConsulta(UUID id) {
      Optional<Consulta> consulta = consultaService.findById(id);
        if (!consulta.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Consulta não encontrada!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(consulta.get());
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Object> deleteConsulta(UUID id) {
        Optional<Consulta> consultaOptional = consultaService.findById(id);
        if (!consultaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Consulta não encontrada!");
        }
        consultaService.delete(consultaOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Consulta deletada com sucesso!");
    }

    @Override
     @PutMapping("/{id}")
    public ResponseEntity<Object> updateConsulta(UUID id, @Valid ConsultaDTO consultaDTO) throws Exception {
        
        Optional<Consulta> consultaOptional = consultaService.findById(id);
        if (!consultaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Consulta não encontrada!");
        }
        Consulta consulta = new Consulta();
        BeanUtils.copyProperties(consultaDTO, consulta);
        consulta.setId(consultaOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(consultaService.save(consulta));

        
    }

}
