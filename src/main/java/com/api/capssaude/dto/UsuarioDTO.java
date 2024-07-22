package com.api.capssaude.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record UsuarioDTO(UUID id, @NotBlank String nome, @NotBlank String senha, @NotBlank String email, @Min(1) int nivelAcesso) {
}
