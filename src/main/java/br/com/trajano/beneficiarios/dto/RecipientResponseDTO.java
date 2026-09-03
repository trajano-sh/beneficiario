package br.com.trajano.beneficiarios.dto;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

public record RecipientResponseDTO(Long id, String name, String phone, LocalDate dateOfBirth, Instant createdAt,
                                   Instant updatedAt, List<DocumentsResponseDTO> documents) {
}
