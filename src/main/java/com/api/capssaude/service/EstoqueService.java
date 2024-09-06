package com.api.capssaude.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.capssaude.interfaces.IEstoqueService;
import com.api.capssaude.model.Estoque;
import com.api.capssaude.repository.EstoqueRepository;

@Service
public class EstoqueService implements IEstoqueService {

    @Autowired
    EstoqueRepository estoqueRepository;

    @Override
    public Estoque save(Estoque estoque) {
        return estoqueRepository.save(estoque);
       
    }

    @Override
    public List<Estoque> findAll() {
        return estoqueRepository.findAll();
    }

    @Override
    public void delete(Estoque estoque) {
        estoqueRepository.delete(estoque);
    }

    @Override
    public Optional<Estoque> findById(UUID id) {
       return estoqueRepository.findById(id);
    }


    
}
