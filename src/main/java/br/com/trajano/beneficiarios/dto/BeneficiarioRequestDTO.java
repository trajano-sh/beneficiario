package br.com.trajano.beneficiarios.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;
import java.time.LocalDate;

public record BeneficiarioRequestDTO(@NotBlank String name,
                                     @NotBlank String phone,
                                     @NotNull LocalDate dateOfBirth
){}