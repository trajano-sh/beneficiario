package br.com.trajano.beneficiarios.database.repository;

import br.com.trajano.beneficiarios.database.model.Documentos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IDocumentosRepository extends JpaRepository<Documentos, Long> {
}
