package br.com.trajano.beneficiarios.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.aspectj.weaver.ast.Not;
import org.hibernate.validator.constraints.br.CNPJ;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

public record BeneficiarioRequestDTO(@NotBlank String name,
                                     @NotBlank String phone,
                                     @NotNull LocalDate dateOfBirth,
                                     @NotNull List<DocumentosRequestDTO> documents
){}