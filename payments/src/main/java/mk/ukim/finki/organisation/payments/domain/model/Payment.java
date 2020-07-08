package mk.ukim.finki.organisation.payments.domain.model;

import lombok.Getter;
import mk.ukim.finki.organisation.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.organisation.sharedkernel.domain.financial.Money;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Table(name="payments")
public class Payment extends AbstractEntity<Paymentid> {
    @Version
    private Long version;
    private Date date;
    @Embedded
    private Money sum;
    @OneToOne
    private Client client;
    @Embedded
    @AttributeOverride(name="id",column = @Column(name="projectId",nullable = false))
    private ProjectId projectId;
    public Payment(){}
    @Override
    public Paymentid id(){return id;}
}
