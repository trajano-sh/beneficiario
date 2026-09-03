package br.com.trajano.beneficiarios.dto;

import java.time.LocalDate;

public record RecipientsResponseDTO(Long id, String name, String phone, LocalDate dateOfBirth) {
}
