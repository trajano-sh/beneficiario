package br.com.trajano.beneficiarios.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DocumentosRequestDTO(
        @NotBlank String typeDocument,
        @NotBlank String description
) {
}
