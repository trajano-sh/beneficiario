package br.com.trajano.beneficiarios.database.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_beneficiarios")
public class Beneficiario {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true)
    private String phone;

    @Column(nullable = false, updatable = false)
    private LocalDate dateOfBirth;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Instant createdAt;

    private Instant updatedAt;

    @OneToMany(mappedBy = "beneficiario", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Object> documents = new ArrayList<>();

}
