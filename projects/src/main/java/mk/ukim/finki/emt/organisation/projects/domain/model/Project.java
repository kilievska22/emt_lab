package mk.ukim.finki.emt.organisation.projects.domain.model;

import lombok.Getter;
import mk.ukim.finki.organisation.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.organisation.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.organisation.sharedkernel.domain.financial.Money;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="project")
@Where(clause="deleted=false")
@Getter
public class Project extends AbstractEntity<ProjectId> {

    @Version
    private Long version;
    @Column(name="name", nullable = false)
    private String name;
    @Column(name="description", nullable = false)
    private String description;

 public Employee getManager() {
  return manager;
 }

 @ManyToOne
    private Employee manager;
    private Date startDate;
    private Date deadline;
    private boolean finished;


 public ProjectId getId() {
  return id;
 }

 public Long getVersion() {
  return version;
 }

 public String getName() {
  return name;
 }

 public String getDescription() {
  return description;
 }

 public Date getStartDate() {
  return startDate;
 }

 public Date getDeadline() {
  return deadline;
 }

 public boolean isFinished() {
  return finished;
 }

 public boolean isPayed() {
  return payed;
 }

 /*public Money getMoney() {
  return money;
 }*/

 public boolean isDeleted() {
  return deleted;
 }

 public Set<Task> getTasks() {
  return tasks;
 }

 private boolean payed;
  /*  @Embedded
    private Money money;*/
  @Enumerated(EnumType.STRING)
  private Currency currency;
    private boolean deleted=false;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Task> tasks;
    @Override
    public ProjectId id(){
        return id;
    }
    public Project(){}
    public Money project_cost(){
     return tasks.stream().map(Task::total_cost).reduce(new Money(currency, 0), Money::add);
    }
    public Task addTask(Task task){
     Objects.requireNonNull(task, "task must not be null");
     tasks.add(task);
     return task;
    }
    public Set<Employee> getEmployees(){
     Set employees= (Set) new ArrayList<Employee>();
    for(Task t:tasks)
    {employees.addAll(t.getEmployees());}
return employees;
     }
 @Embedded
 @AttributeOverride(name="id",column = @Column(name="clientId",nullable = false))
 private ClientId clientId;
    }


