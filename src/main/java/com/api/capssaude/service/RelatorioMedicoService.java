package com.api.capssaude.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.capssaude.interfaces.IRelatorioMedicoService;
import com.api.capssaude.model.RelatorioMedico;
import com.api.capssaude.repository.RelatorioMedicoRepository;

@Service
public class RelatorioMedicoService implements IRelatorioMedicoService{


    @Autowired
    RelatorioMedicoRepository relatorioMedicoRepository;

    @Override
    public RelatorioMedico save(RelatorioMedico relatorioMedico) {
        return relatorioMedicoRepository.save(relatorioMedico);
    }

    @Override
    public List<RelatorioMedico> findAll() {
        return relatorioMedicoRepository.findAll();
    }

    @Override
    public Optional<RelatorioMedico> findById(UUID id) {
        return relatorioMedicoRepository.findById(id);
    }

    @Override
    public void delete(RelatorioMedico relatorioMedico) {
        relatorioMedicoRepository.delete(relatorioMedico);
    }
    
}
