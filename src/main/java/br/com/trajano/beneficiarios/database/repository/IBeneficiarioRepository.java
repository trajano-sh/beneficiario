package br.com.trajano.beneficiarios.database.repository;

import br.com.trajano.beneficiarios.database.model.Beneficiario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IBeneficiarioRepository extends JpaRepository<Beneficiario, UUID> {
}
