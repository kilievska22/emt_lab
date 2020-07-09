package mk.ukim.finki.emt.organisation.projects.domain.model;

import mk.ukim.finki.organisation.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class ClientId extends DomainObjectId {
    public ClientId(String id) {
        super(id);
    }
    public ClientId(){}
    @Override
    public boolean equals(Object o) {

        return ((ClientId) o).getId().equals(getId());


    }
    @Override
    public int hashCode() {

        return getId().hashCode();
    }
}
