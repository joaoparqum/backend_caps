package com.api.capssaude.dto;

import java.util.List;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PsicologoDTO(UUID id,
                @NotBlank String sexo,
                @NotBlank String CRP,
                @NotBlank String email,
                @NotBlank String telefone,
                @NotBlank String endereco,
                @NotNull List<String> diasDisponiveis,
                @NotBlank List<String> horariosDisponiveis,
                @NotBlank String comentarios
) 
{    
}
