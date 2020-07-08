package mk.ukim.finki.emt.organisation.projects.domain.model;

import mk.ukim.finki.organisation.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class EmployeeId extends DomainObjectId {
    public EmployeeId(String id) {
        super(id);
    }
}
