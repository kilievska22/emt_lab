package mk.ukim.finki.organisation.sharedkernel.domain.base;


import org.springframework.lang.NonNull;

import java.time.Instant;
public interface DomainEvent extends DomainObject {


    Instant occurredOn();
}
