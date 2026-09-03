package br.com.trajano.beneficiarios.database.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_recipients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Recipient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true)
    private String phone;

    @Column(nullable = false, updatable = false)
    private LocalDate dateOfBirth;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;

    @OneToMany(mappedBy = "recipient", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Documents> documents = new ArrayList<>();

}
