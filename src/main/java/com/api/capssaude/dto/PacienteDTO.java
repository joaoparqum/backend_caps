package com.api.capssaude.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public record PacienteDTO(UUID id,
                          @NotBlank String nome,
                          @NotBlank String cpf,
                          @NotNull Date dataDeNascimento,
                          String cep,
                          @NotBlank String bairro,
                          @NotBlank String logradouro,
                          @NotBlank String complemento,
                          String telefone,
                          @NotNull List<@NotBlank String> telefonesEmergencia,
                          @NotNull @NotBlank String cartaoSus) {
}
