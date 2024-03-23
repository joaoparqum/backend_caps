package com.api.capssaude.service;

import com.api.capssaude.model.Profissional;
import com.api.capssaude.repository.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProfissionalService {

    @Autowired
    ProfissionalRepository profissionalRepository;

    public Profissional save(Profissional profissional){
        return profissionalRepository.save(profissional);
    }

    public List<Profissional> findAll(){
        return profissionalRepository.findAll();
    }

    public Optional<Profissional> findById(UUID id){
        return profissionalRepository.findById(id);
    }

    public void delete(Profissional profissional) {
        profissionalRepository.delete(profissional);
    }

}
