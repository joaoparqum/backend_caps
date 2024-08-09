package com.api.capssaude.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.capssaude.interfaces.IPsicologoService;
import com.api.capssaude.model.Psicologo;
import com.api.capssaude.repository.PsicologoRepository;

@Service
public class PsicologoService implements IPsicologoService {
    
    
    @Autowired
    PsicologoRepository psicologoRepository;

    @Override
    public Psicologo save(Psicologo psicologo) {
        return psicologoRepository.save(psicologo);
    }

    @Override
    public List<Psicologo> findAll() {
        return psicologoRepository.findAll();
    }

    @Override
    public Optional<Psicologo> findById(UUID id) {
       return psicologoRepository.findById(id);
    }

    @Override
    public void delete(Psicologo psicologo) {
        psicologoRepository.delete(psicologo);
    }

}
