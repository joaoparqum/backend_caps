package com.api.capssaude.service;

import com.api.capssaude.model.Paciente;
import com.api.capssaude.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;

    public Paciente save(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }

    public Optional<Paciente> findById(UUID id) {
        return pacienteRepository.findById(id);
    }

    public void delete(Paciente paciente) {
        pacienteRepository.delete(paciente);
    }

}
