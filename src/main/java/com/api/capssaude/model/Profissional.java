package com.api.capssaude.model;

import com.api.capssaude.pessoa.Pessoa;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "TB_PROFISSIONAL")
@Data
public class Profissional extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String crm;
    private String cod_especialidade;
    private int especialdade;
    private Date dia_atendimento;
    private String hora_atendimento;
}
