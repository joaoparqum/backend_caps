package com.api.capssaude.repository;

import com.api.capssaude.model.TerapeutaOcupacional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TerapeutaOcupacionalRepository extends JpaRepository<TerapeutaOcupacional, UUID> {

}
