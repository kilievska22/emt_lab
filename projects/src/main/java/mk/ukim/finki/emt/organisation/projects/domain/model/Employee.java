package mk.ukim.finki.emt.organisation.projects.domain.model;

import lombok.Getter;
import mk.ukim.finki.organisation.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.organisation.sharedkernel.domain.financial.Money;
import mk.ukim.finki.organisation.sharedkernel.domain.geo.Address;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="employees")
@Getter
public class Employee extends AbstractEntity<EmployeeId> {
    @Version
    private Long version;
    @Column(name="name_sname", nullable = false)
    private String name_sname;
    private String email_address;
    private String phone;
    @ManyToMany
    public Set<Project>projects;
    @Embedded
    private Address address;

    public void setName_sname(String name_sname) {
        this.name_sname = name_sname;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setTariff(Money tariff) {
        this.tariff = tariff;
    }

    public Employee() {
    }

    public Employee(String name_sname, String email_address, String phone, Address address, Money tariff) {
        this.name_sname = name_sname;
        this.email_address = email_address;
        this.phone = phone;
        this.address = address;
        this.tariff = tariff;
    }

    @Embedded
    private Money tariff;

}
