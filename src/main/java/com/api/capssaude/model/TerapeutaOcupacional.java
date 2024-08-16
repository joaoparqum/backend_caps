package com.api.capssaude.model;

import com.api.capssaude.pessoa.Pessoa;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TB_TERAPEUTA")
@Data
public class TerapeutaOcupacional extends Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String sexo;
    private String crefito;
    private String email;
    private List<String> diasDisponiveis;
    private List<String> horariosDisponiveis;
    private String comentarios;

}
