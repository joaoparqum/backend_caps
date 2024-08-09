package com.api.capssaude.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "TB_Psicologo")
@Data
public class Psicologo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    
    private String codigo;
    private String nome;    
    private String sexo;
    private String CRP;
    private Date dataNascimento;
    private String email;
    private String telefone;
    private String endereco;
    private Date diasDiasponiveis;
    private String horariosDisponiveis;
    private String comentarios;
}

