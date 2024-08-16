package com.api.capssaude.interfaces;

import com.api.capssaude.model.TerapeutaOcupacional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ITerapeutaService {

    public TerapeutaOcupacional save(TerapeutaOcupacional terapeutaOcupacional);
    public List<TerapeutaOcupacional> findAll();
    public Optional<TerapeutaOcupacional> findById(UUID id);
    public void delete(TerapeutaOcupacional terapeutaOcupacional);

}
