package com.api.capssaude.service;

import com.api.capssaude.interfaces.ITerapeutaService;
import com.api.capssaude.model.TerapeutaOcupacional;
import com.api.capssaude.repository.TerapeutaOcupacionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TerapeutaOcupacionalService implements ITerapeutaService {

    @Autowired
    TerapeutaOcupacionalRepository terapeutaRepository;

    @Override
    public TerapeutaOcupacional save(TerapeutaOcupacional terapeutaOcupacional){
        return terapeutaRepository.save(terapeutaOcupacional);
    }

    @Override
    public List<TerapeutaOcupacional> findAll(){
        return terapeutaRepository.findAll();
    }

    @Override
    public Optional<TerapeutaOcupacional> findById(UUID id){
        return terapeutaRepository.findById(id);
    }

    @Override
    public void delete(TerapeutaOcupacional terapeutaOcupacional) {
        terapeutaRepository.delete(terapeutaOcupacional);
    }


}
