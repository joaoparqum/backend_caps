package com.api.capssaude.interfaces;

import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.api.capssaude.dto.MedicamentoDTO;
import com.api.capssaude.model.Medicamento;

import jakarta.validation.Valid;

public interface IMedicamentoControl {
        public ResponseEntity<Object> saveMedicamento(@RequestBody @Valid MedicamentoDTO medicamentoDto);
    public ResponseEntity<List<Medicamento>> getAllMedicamento();
    public ResponseEntity<Object> getOneMedicamento(@PathVariable(value = "id") UUID id);
    public ResponseEntity<Object> deleteMedicamento(@PathVariable(value = "id") UUID id);
    public ResponseEntity<Object> updateMedicamento(@PathVariable(value = "id") UUID id, 
                                             @RequestBody @Valid MedicamentoDTO medicamentoDto); 
                                          }

