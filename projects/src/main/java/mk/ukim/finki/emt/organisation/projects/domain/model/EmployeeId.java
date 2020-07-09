package mk.ukim.finki.emt.organisation.projects.domain.model;

import mk.ukim.finki.organisation.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class EmployeeId extends DomainObjectId {
    public EmployeeId(String id) {
        super(id);
    }
    public EmployeeId(){}
    @Override
    public boolean equals(Object o) {

        return ((EmployeeId) o).getId().equals(getId());


    }
    @Override
    public int hashCode() {

        return getId().hashCode();
    }
}
