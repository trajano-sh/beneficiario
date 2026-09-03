package br.com.trajano.beneficiarios.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record RecipientRequestDTO(@NotBlank String name, @NotBlank String phone, LocalDate dateOfBirth,
                                  List<DocumentsRequestDTO> documents) {
}