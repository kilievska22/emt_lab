package mk.ukim.finki.emt.organisation.projects.domain.repository;

import ch.qos.logback.core.net.server.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepository extends JpaRepository<Client, String> {
}
