package mk.ukim.finki.emt.organisation.projects.domain.repository;

import ch.qos.logback.core.net.server.Client;
import mk.ukim.finki.emt.organisation.projects.domain.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepository extends JpaRepository<Employee, String> {
}
