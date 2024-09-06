package com.api.capssaude.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import com.api.capssaude.interfaces.IConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.capssaude.model.Consulta;
import com.api.capssaude.repository.ConsultaRepository;

@Service
public class ConsultaService implements IConsultaService {

    @Autowired
    ConsultaRepository consultaRepository;

    @Override
    public Consulta save(Consulta consulta){
        return consultaRepository.save(consulta);
    }

    @Override
    public List<Consulta> findAll(){
        return consultaRepository.findAll();
    }

    @Override
    public Optional<Consulta> findById(UUID id){
        return consultaRepository.findById(id);
    }

    @Override
    public void delete(Consulta consulta){
        consultaRepository.delete(consulta);
    }

   
}