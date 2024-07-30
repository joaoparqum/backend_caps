package com.api.capssaude.interfaces;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.api.capssaude.dto.ConsultaDTO;
import com.api.capssaude.model.Consulta;
import jakarta.validation.Valid;

public interface IConsultaControl {
    
    public ResponseEntity<Object> saveConsulta(@RequestBody @Valid ConsultaDTO usuDto) throws Exception;
    public ResponseEntity<List<Consulta>> getAllConsulta();
    public ResponseEntity<Object> getOneConsulta(@PathVariable(value = "id") UUID id);
    public ResponseEntity<Object> deleteConsulta(@PathVariable(value = "id") UUID id);
    public ResponseEntity<Object> updateConsulta(@PathVariable(value = "id") UUID id,
        
    @RequestBody @Valid ConsultaDTO consDto) throws Exception;

                                                }
