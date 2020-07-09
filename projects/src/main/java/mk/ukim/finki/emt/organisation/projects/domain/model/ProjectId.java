package mk.ukim.finki.emt.organisation.projects.domain.model;

import mk.ukim.finki.organisation.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class ProjectId extends DomainObjectId {
    public ProjectId(String id) {
        super(id);
    }
    public ProjectId(){}
    @Override
    public boolean equals(Object o) {

     return ((ProjectId) o).getId().equals(getId());


    }
    @Override
    public int hashCode() {

        return getId().hashCode();
    }


}
