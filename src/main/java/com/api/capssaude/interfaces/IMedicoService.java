package com.api.capssaude.interfaces;

import com.api.capssaude.enums.Especialidade;
import com.api.capssaude.model.Medico;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IMedicoService {

    public Medico save(Medico medico);
    public List<Medico> findAll();
    public Optional<Medico> findById(UUID id);
    public void delete(Medico medico);
    public List<Medico> findByEspecialidade(Especialidade especialidade);

}
