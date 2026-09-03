package br.com.trajano.beneficiarios.dto;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public record BeneficiarioResponseDTO(
        Long id,
        String name,
        String phone,
        LocalDate dateOfBirth,
        Instant createdAt,
        Instant updatedAt,
        List<DocumentosResponseDTO> documents
) {
}
