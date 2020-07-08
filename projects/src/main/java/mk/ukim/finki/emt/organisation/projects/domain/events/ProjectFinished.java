package mk.ukim.finki.emt.organisation.projects.domain.events;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.emt.organisation.projects.domain.model.ClientId;
import mk.ukim.finki.emt.organisation.projects.domain.model.Project;
import mk.ukim.finki.emt.organisation.projects.domain.model.ProjectId;
import mk.ukim.finki.organisation.sharedkernel.domain.base.DomainEvent;
import org.springframework.lang.NonNull;

import java.time.Instant;
import java.util.Objects;

@Getter
public class ProjectFinished implements DomainEvent{
    @JsonProperty("clientId")
    private final ClientId clientId;
    @JsonProperty("occurredOn")
    private final Instant occurredOn;

    @JsonCreator
    public ProjectFinished(@JsonProperty("clientId") @NonNull ClientId clientId,
                        @JsonProperty("occurredOn") @NonNull Instant occurredOn) {
        this.clientId = Objects.requireNonNull(clientId, "clientId must not be null");
        this.occurredOn = Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }

    @NonNull
    public ClientId clientId() {
        return clientId;
    }

    @Override
    @NonNull
    public Instant occurredOn() {
        return occurredOn;
    }
}
