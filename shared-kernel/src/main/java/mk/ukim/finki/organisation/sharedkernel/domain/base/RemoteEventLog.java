package mk.ukim.finki.organisation.sharedkernel.domain.base;


import mk.ukim.finki.organisation.sharedkernel.infra.eventlog.StoredDomainEvent;

import java.util.List;

public interface RemoteEventLog {

    List<StoredDomainEvent> events();
}
