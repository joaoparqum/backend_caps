package com.api.capssaude.interfaces;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import com.api.capssaude.model.Consulta;

public interface IConsultaService {
public Consulta save(Consulta consulta);
public List<Consulta> findAll();
public Optional<Consulta> findById(UUID id);
public void delete(Consulta consulta);
 

}
