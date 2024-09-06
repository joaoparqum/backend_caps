package com.api.capssaude.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.capssaude.model.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, UUID> {

}