package com.api.capssaude.repository;

import org.hibernate.validator.constraints.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.capssaude.model.Medicamento;

@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamento, UUID> {

}
