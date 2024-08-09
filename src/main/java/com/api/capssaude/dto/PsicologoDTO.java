package com.api.capssaude.dto;

import java.sql.Date;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PsicologoDTO(UUID id,
                @NotBlank String codigo,
                @NotBlank String nome,
                @NotBlank String sexo,
                @NotBlank String CRP,
                @NotNull Date dataNascimento,
                @NotBlank String email,
                @NotBlank String telefone,
                @NotBlank String endereco,
                @NotNull Date diasDisponiveis,
                @NotBlank String horariosDisponiveis,
                @NotBlank String comentarios
) 
{    
}
