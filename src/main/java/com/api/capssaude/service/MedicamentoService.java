package com.api.capssaude.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.capssaude.interfaces.IMedicamentoService;
import com.api.capssaude.model.Medicamento;
import com.api.capssaude.repository.MedicamentoRepository;

@Service
public class MedicamentoService implements IMedicamentoService {

     @Autowired
     MedicamentoRepository medicamentoRepository;

    @Override
    public Medicamento save(Medicamento medicamento) {
        return medicamentoRepository.save(medicamento);    
    }

    @Override
    public List<Medicamento> findAll() {
        return medicamentoRepository.findAll();    
    }

    @Override
    public Optional<Medicamento> findById(UUID id) {
        return medicamentoRepository.findById(id);    
    }

    @Override
    public void delete(Medicamento medicamento) {
        medicamentoRepository.delete(medicamento);    
    }
    
}
