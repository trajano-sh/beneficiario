package br.com.trajano.beneficiarios.dto;

import java.time.LocalDate;
import java.util.UUID;

public record BeneficiariosResponseDTO(UUID id, String name, String phone, LocalDate dateOfBirth) {
}
