package com.api.capssaude.interfaces;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import com.api.capssaude.dto.PsicologoDTO;
import com.api.capssaude.model.Psicologo;

import jakarta.validation.Valid;

public interface IPsicologoControl {
    public ResponseEntity<Object> savePsicologo(@RequestBody @Valid PsicologoDTO psicologoDTO)throws Exception;
    public ResponseEntity<List<Psicologo>> getAllPsicologo();
    public ResponseEntity<Object> getOnePsicologo(@PathVariable(value = "id") UUID id);
    public ResponseEntity<Object> deletePsicologo(@PathVariable(value = "id") UUID id);
    public ResponseEntity<Object> updatePsicologo(@PathVariable(value = "id") UUID id, 
                                             @RequestBody @Valid PsicologoDTO psicologoDTO);
}
