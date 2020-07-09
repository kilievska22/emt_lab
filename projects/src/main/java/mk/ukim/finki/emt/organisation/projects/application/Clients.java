package mk.ukim.finki.emt.organisation.projects.application;

import mk.ukim.finki.emt.organisation.projects.domain.model.Client;
import mk.ukim.finki.emt.organisation.projects.domain.model.ClientId;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Component
public interface Clients {
    List<Client> findAll();

    Client findById(ClientId id);
}
