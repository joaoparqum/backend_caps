package com.api.capssaude.interfaces;

import java.util.List;
import com.api.capssaude.model.Consulta;

public interface IConsultaService {
public Consulta save(Consulta consulta);
public List<Consulta> findAll();
public void delete(Consulta consulta);
 

}
