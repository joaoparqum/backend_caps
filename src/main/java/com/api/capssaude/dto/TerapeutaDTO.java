package com.api.capssaude.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public record TerapeutaDTO(UUID id,
                           @NotBlank String nome,
                           @NotBlank String sexo,
                           @NotNull String crefito,
                           @NotBlank String email,
                           @NotBlank String telefone,
                           @Size(min = 8, max = 9) String cep,
                           @NotNull Date dataDeNascimento,
                           @Size(min = 11, max = 11) @NotBlank String cpf,
                           @NotBlank String logradouro,
                           @NotBlank String bairro,
                           @NotNull List<@NotBlank String> diasDisponiveis,
                           @NotNull List<@NotBlank String> horariosDisponiveis,
                           @NotBlank String comentarios) {
}
