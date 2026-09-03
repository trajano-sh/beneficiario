package br.com.trajano.beneficiarios.dto;

import java.time.Instant;

public record DocumentsResponseDTO(Long id, String typeDocument, String description, Instant createdAt,
                                   Instant updatedAt, Long recipientId) {
}
