package mk.ukim.finki.organisation.payments.domain.model;

import mk.ukim.finki.organisation.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class ProjectId extends DomainObjectId {
    public ProjectId(String id) {
        super(id);
    }
}
