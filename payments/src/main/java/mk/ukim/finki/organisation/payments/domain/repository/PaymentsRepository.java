package mk.ukim.finki.organisation.payments.domain.repository;

import mk.ukim.finki.organisation.payments.domain.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentsRepository extends JpaRepository<Payment, String> {
}
