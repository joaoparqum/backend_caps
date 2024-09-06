package com.api.capssaude.dto;

import com.api.capssaude.enums.Especialidade;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public record MedicoDTO(UUID id,
                        @NotBlank String nome,
                        @NotBlank String cpf,
                        @NotNull Date dataDeNascimento,
                        String cep,
                        @NotBlank String bairro,
                        @NotBlank String logradouro,
                        @NotBlank String complemento,
                        String telefone,
                        @NotBlank String sexo,
                        @NotNull Especialidade especialidade,
                        @NotNull String codEspecialidade,
                        @NotNull List<@NotBlank String> diasAtendimento,
                        @NotNull List<@NotBlank String> horasAtendimento,
                        @NotBlank String comentarios){
}
