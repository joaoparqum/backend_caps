package com.api.capssaude.interfaces;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.api.capssaude.dto.EnfermeiroDTO;
import com.api.capssaude.model.Enfermeiro;

import jakarta.validation.Valid;

public interface IEnfermeiroControl{
    public ResponseEntity<Object> saveEnfermeiro(@RequestBody @Valid EnfermeiroDTO enfermeiroDTO)throws Exception;
    public ResponseEntity<List<Enfermeiro>> getAllEnfermeiro();
    public ResponseEntity<Object> getOneEnfermeiro(@PathVariable(value = "id") UUID id);
    public ResponseEntity<Object> deleteEnfermeiro(@PathVariable(value = "id") UUID id);
    public ResponseEntity<Object> updateEnfermeiro(@PathVariable(value = "id") UUID id, 
                                             @RequestBody @Valid EnfermeiroDTO enfermeiroDTO);
}