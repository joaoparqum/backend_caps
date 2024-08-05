package com.api.capssaude.model;

import java.util.UUID;
import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "TB_Medicamento")
@Data
public class Medicamento{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull
    private String nomeMedicamento;
    @NotNull
    private String descricao;
    @NotNull
    private String horario;
    @NotNull
    private String dosagem;
    @ManyToOne
    @JoinColumn(name = "consulta_id")
    private Consulta consulta;

}
