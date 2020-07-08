package mk.ukim.finki.emt.organisation.projects.application;


import mk.ukim.finki.emt.organisation.projects.application.form.ProjectForm;
import mk.ukim.finki.emt.organisation.projects.domain.events.ProjectFinished;
import mk.ukim.finki.emt.organisation.projects.domain.model.ClientId;
import mk.ukim.finki.emt.organisation.projects.domain.model.Project;
import mk.ukim.finki.emt.organisation.projects.domain.model.ProjectId;
import mk.ukim.finki.emt.organisation.projects.domain.repository.ProjectsRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.time.Instant;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class Projects {
    private final ProjectsRepository projectsRepository;

    private final ApplicationEventPublisher applicationEventPublisher;

    private final Validator validator;

    private  Clients clients;


    public Projects(ProjectsRepository projectsRepository, Clients clients, ApplicationEventPublisher applicationEventPublisher, Validator validator) {
        this.projectsRepository = projectsRepository;
        this.applicationEventPublisher = applicationEventPublisher;
        this.validator = validator;
        this.clients = clients;
    }
    public ClientId finishProject(@NonNull Project project) {
        Objects.requireNonNull(project,"project must not be null");
        var constraintViolations = validator.validate(project);

        if (constraintViolations.size() > 0) {
            throw new ConstraintViolationException("The ProjectForm is not valid", constraintViolations);
        }

      project.finish();
        projectsRepository.save(project);
        applicationEventPublisher.publishEvent(new ProjectFinished(project.getClientId(),Instant.now()));
        //newOrder.getItems().forEach(orderItem -> applicationEventPublisher.publishEvent(new OrderItemAdded(newOrder.id(),orderItem.id(),orderItem.getProductId(),orderItem.getQuantity(), Instant.now())));
        return project.getClientId();
    }

    @NonNull
    public Optional<Project> findById(@NonNull ProjectId projectId) {
        Objects.requireNonNull(projectId, "projectId must not be null");
        return projectsRepository.findById(projectId);
    }

   /* @NonNull
    private Project toDomainModel(@NonNull ProjectForm projectForm) {
        var project = new Project (projectForm.getName(), projectForm.getDescription(), projectForm.getStartDate(),
                projectForm.getDeadline(), projectForm.getFinished(),
                toDomainModel(projectForm.getManager()));
        projectForm.getTasks().forEach(task -> project.addTask(item.getProduct(), item.getQuantity()));
        return order;
    }

    @NonNull
    private RecipientAddress toDomainModel(@NonNull RecipientAddressForm form) {
        return new RecipientAddress(form.getName(), form.getAddress(),form.getCity(), form.getCountry());*/
    }













