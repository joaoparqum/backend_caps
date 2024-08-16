package com.api.capssaude.model;

import com.api.capssaude.pessoa.Pessoa;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TB_PROFISSIONAL")
@Data
public class Profissional extends Pessoa implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String sexo;
    private String crm;
    private String codEspecialidade;
    private int especialdade;
    private List<Date> diaAtendimento;
    private List<String> horaAtendimento;
}