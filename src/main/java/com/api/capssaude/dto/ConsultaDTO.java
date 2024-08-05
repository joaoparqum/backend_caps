package com.api.capssaude.dto;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import com.api.capssaude.model.Paciente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ConsultaDTO( UUID id,
@Size(max = 15) @NotBlank String codigo,
@NotNull Paciente paciente,
@NotNull Date data,
@NotNull String horario,
@NotBlank String sintomas,
@NotNull String duracao,
@NotNull List<String> medicamento,
@NotBlank String orientacao,
@NotNull String AcompanhanteLegal  
){

}
