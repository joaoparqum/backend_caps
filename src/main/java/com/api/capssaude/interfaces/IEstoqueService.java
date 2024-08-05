package com.api.capssaude.interfaces;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import com.api.capssaude.model.Estoque;

public interface IEstoqueService {
    
public Estoque save(Estoque estoque);
public List<Estoque> findAll();
public Optional<Estoque> findById(UUID id);
public void delete(Estoque estoque);

}
