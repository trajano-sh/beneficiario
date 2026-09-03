package br.com.trajano.beneficiarios.database.repository;

import br.com.trajano.beneficiarios.database.model.Recipient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRecipientsRepository extends JpaRepository<Recipient, Long> {
}
