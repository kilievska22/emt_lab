package mk.ukim.finki.organisation.payments.integration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.organisation.payments.domain.model.ClientId;
import mk.ukim.finki.organisation.sharedkernel.domain.base.DomainEvent;

import java.time.Instant;
@Getter
public class ProjectFinishedEvent implements DomainEvent {
    @JsonProperty("clientId")
    private final ClientId clientId;
    @JsonProperty("occurredOn")
    private final Instant occurredOn;
@JsonCreator
    public ProjectFinishedEvent(ClientId clientId, Instant occurredOn) {
        this.clientId = clientId;
        this.occurredOn = occurredOn;
    }

    @Override
    public Instant occurredOn() {
        return occurredOn;
    }
}
