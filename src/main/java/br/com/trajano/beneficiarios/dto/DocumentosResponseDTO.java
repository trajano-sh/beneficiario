package br.com.trajano.beneficiarios.dto;

import java.time.Instant;
import java.util.UUID;

public record DocumentosResponseDTO(
        UUID id,
        String typeDocument,
        String description,
        Instant createdAt,
        Instant updatedAt,
        UUID recipientId
) {
}
