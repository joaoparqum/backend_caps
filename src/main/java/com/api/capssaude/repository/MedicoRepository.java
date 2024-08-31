package com.api.capssaude.repository;

import com.api.capssaude.enums.Especialidade;
import com.api.capssaude.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, UUID> {

    List<Medico> findByEspecialidade(Especialidade especialidade);

}
