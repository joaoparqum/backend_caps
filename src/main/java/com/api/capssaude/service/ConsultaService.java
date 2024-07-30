package com.api.capssaude.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.capssaude.model.Consulta;
import com.api.capssaude.repository.ConsultaRepository;

@Service
public class ConsultaService{

@Autowired
ConsultaRepository consultaRepository;

public Consulta save(Consulta consulta){
return consultaRepository.save(consulta);
}

public List<Consulta> findAll(){
return consultaRepository.findAll();
}

public Optional<Consulta> findById(UUID id){
return consultaRepository.findById(id);
}

public void delete(Consulta consulta){
consultaRepository.delete(consulta);
}


}
