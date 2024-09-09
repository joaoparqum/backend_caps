package com.api.capssaude.interfaces;

import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.api.capssaude.dto.RelatorioMedicoDTO;
import com.api.capssaude.model.RelatorioMedico;

import jakarta.validation.Valid;

public interface IRelatorioMedicoControl {
    
    public ResponseEntity<Object> saveRelatorioMedico(@RequestBody @Valid RelatorioMedicoDTO relatorioMedicoDTO);
    public ResponseEntity<List<RelatorioMedico>> getAllRelatorioMedico();
    public ResponseEntity<Object> getOneRelatorioMedico(@PathVariable(value = "id") UUID id);
    public ResponseEntity<Object> deleteRelatorioMedico(@PathVariable(value = "id") UUID id);
    public ResponseEntity<Object> updateRelatorioMedico(@PathVariable(value = "id") UUID id,
                                                 @RequestBody @Valid RelatorioMedicoDTO relatorioMedicoDTO);

}
