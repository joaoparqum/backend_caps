package com.api.capssaude.dto;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;

public record EstoqueDTO (UUID id,
 @NotBlank String test){
}
