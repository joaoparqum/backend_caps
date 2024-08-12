package com.api.capssaude.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

import com.api.capssaude.pessoa.Pessoa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "TB_Psicologo")
@Data
public class Psicologo extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    
    private String sexo;
    private String CRP;
    private String email;
    //private String endereco;
    private List<String> diasDisponiveis;
    private List<String> horariosDisponiveis;
    private String comentarios;
}

