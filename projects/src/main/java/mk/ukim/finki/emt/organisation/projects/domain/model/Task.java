package mk.ukim.finki.emt.organisation.projects.domain.model;

import lombok.Getter;
import mk.ukim.finki.organisation.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.organisation.sharedkernel.domain.financial.Money;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "tasks")
@Getter
public class Task extends AbstractEntity<TaskId> {
    private Date startDate;
    @ManyToOne
    private Project project;
    @Embedded
    private Money cost_per_hour;
    private String description;
    private int hours;

    public Set<Employee> getEmployees() {
        return employees;
    }

    @ManyToMany
    private Set<Employee>employees;
    public Task(Date startDate, Project project, Money cost, String description, int hours, Set<Employee> employees) {
        this.startDate = startDate;
        this.project = project;
        if(cost.getAmount()<0){throw new IllegalArgumentException("Cost cannot be negative!!!");}
        this.cost_per_hour = cost;
        this.description = description;
        if(hours<0){throw new IllegalArgumentException("Hours cannot be negative!!!");}
        this.hours = hours;
        this.employees = employees;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public void setCost(Money cost) {
        if(cost.getAmount()<0){throw new IllegalArgumentException("Cost cannot be negative!!!");}
        this.cost_per_hour = cost;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setHours(int hours) {
        if(hours<0){throw new IllegalArgumentException("Hours cannot be negative!!!");}
        this.hours = hours;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }


    @Override
    public TaskId id(){return id;}
    public Task(){}
    public Money total_cost(){return cost_per_hour.multiply(hours);}

}
