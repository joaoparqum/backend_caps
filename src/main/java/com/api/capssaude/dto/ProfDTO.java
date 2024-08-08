package com.api.capssaude.dto;

import com.api.capssaude.pessoa.Pessoa;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public record ProfDTO(UUID id,
                      @NotBlank String nome,
                      @Size(min = 11, max = 11) @NotBlank String cpf,
                      @NotNull Date dataDeNascimento,
                      @Size(min = 8, max = 9) String cep,
                      @NotBlank String bairro,
                      @NotBlank String logradouro,
                      @NotBlank String complemento,
                      @Size(min = 11, max = 11) String telefone,
                      @NotBlank String sexo,
                      @NotBlank String crm,
                      @NotBlank String codEspecialidade,
                      @Min(1) int especialdade,
                      @NotNull List<Date> diaAtendimento,
                      @NotNull List<@NotBlank String> horaAtendimento){
}
