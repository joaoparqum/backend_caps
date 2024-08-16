package com.api.capssaude.interfaces;

import com.api.capssaude.dto.TerapeutaDTO;
import com.api.capssaude.model.TerapeutaOcupacional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

public interface ITerapeutaController {

    public ResponseEntity<Object> saveTerapeuta(@RequestBody @Valid TerapeutaDTO terapeutaDto);
    public ResponseEntity<List<TerapeutaOcupacional>> getAllTerapeuta();
    public ResponseEntity<Object> getOneTerapeuta(@PathVariable(value = "id") UUID id);
    public ResponseEntity<Object> deleteTerapeuta(@PathVariable(value = "id") UUID id);
    public ResponseEntity<Object> updateTerapeuta(@PathVariable(value = "id") UUID id,
                                                  @RequestBody @Valid TerapeutaDTO terapeutaDto);
}
