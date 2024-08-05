package com.api.capssaude.dto;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import com.api.capssaude.model.Medicamento;
import com.api.capssaude.model.Paciente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ConsultaDTO( UUID id,
@NotNull Paciente paciente,
@NotNull Date data,
@NotNull String horario,
@NotBlank String sintomas,
@NotNull String duracao,
@NotNull List<Medicamento> medicamento,
@NotBlank String orientacao,
@NotNull String AcompanhanteLegal  
){

}
