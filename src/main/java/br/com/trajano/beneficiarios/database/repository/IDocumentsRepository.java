package br.com.trajano.beneficiarios.database.repository;

import br.com.trajano.beneficiarios.database.model.Documents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDocumentsRepository extends JpaRepository<Documents, Long> {
}
