package com.api.capssaude.dto;

import com.api.capssaude.pessoa.Pessoa;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Date;
public record ProfDTO(@NotBlank String crm,
                      @NotBlank String cod_especialidade,
                      @NotBlank int especialdade,
                      @NotBlank Date dia_atendimento,
                      @NotBlank String hora_atendimento){
}
