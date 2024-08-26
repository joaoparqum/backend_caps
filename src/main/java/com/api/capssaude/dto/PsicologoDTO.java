package com.api.capssaude.dto;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PsicologoDTO(UUID id,
                @NotBlank String nome,
                @NotBlank String sexo,
                @NotNull String CRP,
                @NotBlank String email,
                @NotBlank String telefone,
                //@NotBlank String endereco,
                String cep,
                @NotNull Date dataDeNascimento,
                @NotBlank String cpf,
                @NotBlank String logradouro,
                @NotBlank String bairro,
                @NotNull List<@NotBlank String> diasDisponiveis,
                @NotNull List<@NotBlank String> horariosDisponiveis,
                @NotBlank String comentarios
) 
{    
}
