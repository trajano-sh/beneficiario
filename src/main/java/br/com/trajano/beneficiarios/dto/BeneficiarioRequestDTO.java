package br.com.trajano.beneficiarios.dto;

import java.time.Instant;
import java.time.LocalDate;

public record BeneficiarioRequestDTO(String name,
                                     String phone,
                                     LocalDate dateOfBirth
){}