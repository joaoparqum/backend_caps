package com.api.capssaude.interfaces;

import com.api.capssaude.dto.MedicoDTO;
import com.api.capssaude.model.Medico;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

public interface IMedicoControl {

    public ResponseEntity<Object> saveProf(@RequestBody @Valid MedicoDTO medicoDto);
    public ResponseEntity<List<Medico>> getAllProf();
    public ResponseEntity<Object> getOneProf(@PathVariable(value = "id") UUID id);
    public ResponseEntity<Object> deleteProf(@PathVariable(value = "id") UUID id);
    public ResponseEntity<Object> updateProf(@PathVariable(value = "id") UUID id,
                                             @RequestBody @Valid MedicoDTO medicoDto);

}
