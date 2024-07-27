package com.api.capssaude.interfaces;

import com.api.capssaude.dto.PacienteDTO;
import com.api.capssaude.model.Paciente;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

public interface IPacienteControl {

    public ResponseEntity<Object> savePaciente(@RequestBody @Valid PacienteDTO pacienteDTO);
    public ResponseEntity<List<Paciente>> getAllPaciente();
    public ResponseEntity<Object> getOnePaciente(@PathVariable(value = "id") UUID id);
    public ResponseEntity<Object> deletePaciente(@PathVariable(value = "id") UUID id);
    public ResponseEntity<Object> updatePaciente(@PathVariable(value = "id") UUID id,
                                                 @RequestBody @Valid PacienteDTO pacienteDTO);

}
