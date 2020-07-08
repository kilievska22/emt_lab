package mk.ukim.finki.organisation.payments.domain.model;

import mk.ukim.finki.organisation.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.organisation.sharedkernel.domain.geo.Address;

import javax.persistence.*;

@Entity
@Table(name="client")
public class Client extends AbstractEntity<ClientId>{

    @Version
    private Long version;
    @Column(nullable = false)
    private String name_sname;
    @Column(nullable = false)
    private String email;
  @Embedded
    @AttributeOverrides({

            @AttributeOverride(name = "address", column = @Column(name = "billing_address", nullable = false)),
            @AttributeOverride(name = "city", column = @Column(name = "billing_city", nullable = false)),
            @AttributeOverride(name = "country", column = @Column(name = "billing_country", nullable = false))
    })
    private Address address;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private boolean isActive;
    public void changeStatus(){isActive=!isActive;}

    @Override
    public ClientId id(){return id;}
   public Client(){}
}
