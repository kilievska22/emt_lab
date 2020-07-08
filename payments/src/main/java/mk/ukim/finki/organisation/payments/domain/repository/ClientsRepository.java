package mk.ukim.finki.organisation.payments.domain.repository;

import mk.ukim.finki.organisation.payments.domain.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientsRepository extends JpaRepository<Client, String> {
}
