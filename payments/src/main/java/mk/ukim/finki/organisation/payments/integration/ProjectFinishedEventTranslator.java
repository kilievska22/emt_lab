package mk.ukim.finki.organisation.payments.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import mk.ukim.finki.organisation.sharedkernel.domain.base.DomainEvent;
import mk.ukim.finki.organisation.sharedkernel.infra.eventlog.RemoteEventTranslator;
import mk.ukim.finki.organisation.sharedkernel.infra.eventlog.StoredDomainEvent;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectFinishedEventTranslator implements RemoteEventTranslator {

    private final ObjectMapper objectMapper;



    public ProjectFinishedEventTranslator(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public boolean supports(StoredDomainEvent storedDomainEvent) {
        return storedDomainEvent.domainEventClassName().equals("mk.ukim.finki.emt.organisation.projects.domain.events.ProjectFinished");

    }

    @Override
    public Optional<DomainEvent> translate(StoredDomainEvent remoteEvent) {
        return Optional.of(remoteEvent.toDomainEvent(objectMapper, ProjectFinishedEvent.class));
    }
}
