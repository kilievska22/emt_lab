package mk.ukim.finki.emt.organisation.projects.domain.repository;

import mk.ukim.finki.emt.organisation.projects.domain.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TasksRepository extends JpaRepository<Task, String> {
}
