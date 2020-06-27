package mk.ukim.finki.emt.organisation.projects.domain.model;

import lombok.Getter;
import mk.ukim.finki.organisation.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.organisation.sharedkernel.domain.financial.Money;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="project")
@Where(clause="deleted=false")
@Getter
public class Project extends AbstractEntity<ProjectId> {
   @EmbeddedId
   ProjectId id;
    @Version
    private Long version;
    @Column(name="name", nullable = false)
    private String name;
    @Column(name="description", nullable = false)
    private String description;
    private Date startDate;
    private Date deadline;
    private boolean finished;
    private boolean payed;
    @Embedded
    private Money money;
    private boolean deleted=false;
    @Override
    public ProjectId id(){
        return id;
    }
}

