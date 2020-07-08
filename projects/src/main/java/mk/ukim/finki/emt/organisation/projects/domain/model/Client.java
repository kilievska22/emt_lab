package mk.ukim.finki.emt.organisation.projects.domain.model;

import lombok.Getter;
import mk.ukim.finki.organisation.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.organisation.sharedkernel.domain.geo.Address;

import javax.persistence.*;

@Getter
public class Client extends AbstractEntity<ClientId>{

    private String name_sname;

    private String email;

    private Address address;

    private String phone;

    private boolean isActive;

    private ClientId id;

}
