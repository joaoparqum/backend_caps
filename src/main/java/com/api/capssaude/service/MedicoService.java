package com.api.capssaude.service;

import com.api.capssaude.enums.Especialidade;
import com.api.capssaude.interfaces.IMedicoService;
import com.api.capssaude.model.Medico;
import com.api.capssaude.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MedicoService implements IMedicoService {

    @Autowired
    MedicoRepository medicoRepository;

    @Override
    public Medico save(Medico medico){
        return medicoRepository.save(medico);
    }

    @Override
    public List<Medico> findAll(){
        return medicoRepository.findAll();
    }

    @Override
    public Optional<Medico> findById(UUID id){
        return medicoRepository.findById(id);
    }

    @Override
    public void delete(Medico medico) {
        medicoRepository.delete(medico);
    }

    @Override
    public List<Medico> findByEspecialidade(Especialidade especialidade){
        return medicoRepository.findByEspecialidade(especialidade);
    }

}
