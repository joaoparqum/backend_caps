package com.api.capssaude.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.capssaude.interfaces.IEnfermeiroService;
import com.api.capssaude.model.Enfermeiro;
import com.api.capssaude.repository.EnfermeiroRepository;

@Service
public class EnfermeiroService implements IEnfermeiroService{

    @Autowired
    EnfermeiroRepository enfermeiroRepository;

    @Override
    public Enfermeiro save(Enfermeiro enfermeiro) {
       return enfermeiroRepository.save(enfermeiro);
    }

    @Override
    public List<Enfermeiro> findAll() {
        return enfermeiroRepository.findAll();
    }

    @Override
    public Optional<Enfermeiro> findById(UUID id) {
        return enfermeiroRepository.findById(id);
    }

    @Override
    public void delete(Enfermeiro enfermeiro) {
      enfermeiroRepository.delete(enfermeiro);
    }
    
}
