package com.api.capssaude.service;

import com.api.capssaude.interfaces.IProfissionalService;
import com.api.capssaude.model.Profissional;
import com.api.capssaude.repository.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProfissionalService implements IProfissionalService {

    @Autowired
    ProfissionalRepository profissionalRepository;

    @Override
    public Profissional save(Profissional profissional){
        return profissionalRepository.save(profissional);
    }

    @Override
    public List<Profissional> findAll(){
        return profissionalRepository.findAll();
    }

    @Override
    public Optional<Profissional> findById(UUID id){
        return profissionalRepository.findById(id);
    }

    @Override
    public void delete(Profissional profissional) {
        profissionalRepository.delete(profissional);
    }

}
