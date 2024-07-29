package com.api.capssaude.service;

import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;
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
        validateCPF(paciente.getCpf());
        return pacienteRepository.save(paciente);
    }

    //método para validar o CPF, da dependencia stella core
    private void validateCPF(String cpf) {
        CPFValidator cpfValidator = new CPFValidator();
        try {
            cpfValidator.assertValid(cpf);
        } catch (InvalidStateException e) {
            List<ValidationMessage> messages = e.getInvalidMessages();
            throw new IllegalArgumentException("CPF Inválido: " + messages.toString());
        }
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
