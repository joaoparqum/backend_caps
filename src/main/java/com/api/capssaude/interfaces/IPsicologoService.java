package com.api.capssaude.interfaces;

import com.api.capssaude.model.Psicologo;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IPsicologoService {
    
    public Psicologo save(Psicologo psicologo);
    public List<Psicologo> findAll();
    public Optional<Psicologo> findById(UUID id);
    public void delete(Psicologo psicologo);
}
