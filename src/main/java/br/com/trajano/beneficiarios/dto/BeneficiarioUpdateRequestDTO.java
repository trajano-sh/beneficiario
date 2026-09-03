package br.com.trajano.beneficiarios.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record BeneficiarioUpdateRequestDTO(@NotBlank String name,@NotBlank String phone, @NotNull @Past LocalDate dateOfBirth) {
}
