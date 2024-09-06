package com.api.capssaude.dto;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;

public record MedicamentoDTO (UUID id,
     @NotBlank String nomeMedicamento,
     @NotBlank String descricao,
     @NotBlank String horario,
     @NotBlank String dosagem
     )                          
{}

