package mk.ukim.finki.organisation.payments.domain.model;

import mk.ukim.finki.organisation.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class ClientId extends DomainObjectId {
    public ClientId(String id) {
        super(id);
    }
}
