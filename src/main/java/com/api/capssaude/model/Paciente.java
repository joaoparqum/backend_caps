package com.api.capssaude.model;

import com.api.capssaude.pessoa.Pessoa;
import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TB_PACIENTE")
@Data
public class Paciente extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private List<String> telefonesEmergencia;
    private String cartaoSus;
}
