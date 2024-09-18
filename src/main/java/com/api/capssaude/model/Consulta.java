package com.api.capssaude.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "TB_Consulta")
@Data
public class Consulta implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull
    private String paciente;
    @NotNull
    private Date data;
    @NotNull
    private String horario;
    @NotNull
    private String sintomas;
    private String duracao;
    //@OneToMany(mappedBy = "consulta")
    //private List<Medicamento> medicamento;
    @NotNull
    private String orientacao;
    private String AcompanhanteLegal;
}
