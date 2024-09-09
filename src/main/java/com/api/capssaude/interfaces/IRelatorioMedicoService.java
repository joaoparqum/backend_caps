package com.api.capssaude.interfaces;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import com.api.capssaude.model.RelatorioMedico;

public interface IRelatorioMedicoService {
    
    public RelatorioMedico save(RelatorioMedico relatorioMedico);
    public List<RelatorioMedico> findAll();
    public Optional<RelatorioMedico> findById(UUID id);
    public void delete(RelatorioMedico relatorioMedico);
}
