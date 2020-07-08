package mk.ukim.finki.emt.organisation.projects.domain.repository;

import mk.ukim.finki.emt.organisation.projects.domain.model.Project;
import mk.ukim.finki.emt.organisation.projects.domain.model.ProjectId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectsRepository extends JpaRepository<Project, ProjectId> {
}
