package com.api.capssaude.interfaces;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.api.capssaude.model.Enfermeiro;

public interface IEnfermeiroService {
    
    public Enfermeiro save(Enfermeiro enfermeiro);
    public List<Enfermeiro> findAll();
    public Optional<Enfermeiro> findById(UUID id);
    public void delete(Enfermeiro enfermeiro);
}
