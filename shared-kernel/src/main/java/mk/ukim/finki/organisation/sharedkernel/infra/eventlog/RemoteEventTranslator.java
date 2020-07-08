package mk.ukim.finki.organisation.sharedkernel.infra.eventlog;


import mk.ukim.finki.organisation.sharedkernel.domain.base.DomainEvent;

import java.util.Optional;

public interface RemoteEventTranslator {

    boolean supports(StoredDomainEvent storedDomainEvent);

    Optional<DomainEvent> translate(StoredDomainEvent remoteEvent);
}
