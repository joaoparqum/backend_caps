package com.api.capssaude.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record UsuarioDTO(@NotBlank UUID id, @NotBlank String nome, @NotBlank String senha, @NotBlank String email, @NotBlank int nivelAcesso) {
}
