package com.api.capssaude.model;

import com.api.capssaude.enums.Especialidade;
import com.api.capssaude.pessoa.Pessoa;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TB_MEDICO")
@Data
public class Medico extends Pessoa implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String sexo;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    private String codEspecialidade;
    private List<String> diasAtendimento;
    private List<String> horasAtendimento;
    private String comentarios;

    public String getCodigoRegistro() {
        return this.especialidade.getCodigoRegistro();
    }
}