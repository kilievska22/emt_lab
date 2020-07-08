package mk.ukim.finki.emt.organisation.projects.domain.model;

import mk.ukim.finki.organisation.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.organisation.sharedkernel.domain.base.DomainObjectId;

public class TaskId extends DomainObjectId {
    protected String id;


    public TaskId(String id) {
        super(id);
    }
}
