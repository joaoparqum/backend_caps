package com.api.capssaude.service;

import com.api.capssaude.interfaces.IPacienteService;
import com.api.capssaude.model.Paciente;
import com.api.capssaude.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PacienteService implements IPacienteService {

    @Autowired
    PacienteRepository pacienteRepository;

    @Override
    public Paciente save(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }

    @Override
    public Optional<Paciente> findById(UUID id) {
        return pacienteRepository.findById(id);
    }

    @Override
    public void delete(Paciente paciente) {
        pacienteRepository.delete(paciente);
    }

}
