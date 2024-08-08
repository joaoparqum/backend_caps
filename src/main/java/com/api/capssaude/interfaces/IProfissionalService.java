package com.api.capssaude.interfaces;

import com.api.capssaude.model.Profissional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IProfissionalService {

    public Profissional save(Profissional profissional);
    public List<Profissional> findAll();
    public Optional<Profissional> findById(UUID id);
    public void delete(Profissional profissional);

}
