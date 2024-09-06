package com.api.capssaude.interfaces;

import com.api.capssaude.model.Paciente;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IPacienteService {

    public Paciente save(Paciente paciente);
    public List<Paciente> findAll();
    public Optional<Paciente> findById(UUID id);
    public void delete(Paciente paciente);

}
