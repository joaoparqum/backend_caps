package com.api.capssaude.dto;

import org.hibernate.validator.constraints.UUID;

import jakarta.validation.constraints.NotBlank;

public record MedicamentoDTO (UUID id,
    @NotBlank String codigo,
     @NotBlank String nomeMedicamento,
     @NotBlank String descricao,
     @NotBlank String horario,
     @NotBlank String dosagem)                          
{}

//código, nome do medicamento, descrição, horário, dosagem,