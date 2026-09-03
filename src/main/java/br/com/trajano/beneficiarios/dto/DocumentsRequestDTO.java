package br.com.trajano.beneficiarios.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DocumentsRequestDTO(@NotBlank @Size(min = 3, max = 40) String typeDocument,
                                  @NotBlank @Size(min = 3, max = 300) String description) {
}
