package com.api.capssaude.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public record PacienteDTO(UUID id,
                          @NotBlank String nome,
                          @Size(min = 11, max = 11) @NotBlank String cpf,
                          @NotNull Date dataDeNascimento,
                          @Size(min = 9, max = 9) String cep,
                          @NotBlank String bairro,
                          @NotBlank String logradouro,
                          @NotBlank String complemento,
                          @Size(min = 11, max = 11) String telefone,
                          @NotNull List<@NotBlank String> telefonesEmergencia) {
}
