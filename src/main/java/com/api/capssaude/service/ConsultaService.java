package com.api.capssaude.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.api.capssaude.interfaces.IConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.capssaude.model.Consulta;
import com.api.capssaude.repository.ConsultaRepository;

import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;

@Service
public class ConsultaService implements IConsultaService {

    @Autowired
    ConsultaRepository consultaRepository;

    @Override
    public Consulta save(Consulta consulta){
        validateCPF(consulta.getCpf());
        return consultaRepository.save(consulta);
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
    public List<Consulta> findAll(){
        return consultaRepository.findAll();
    }

    @Override
    public Optional<Consulta> findById(UUID id){
        return consultaRepository.findById(id);
    }

    @Override
    public void delete(Consulta consulta){
        consultaRepository.delete(consulta);
    }

   
}