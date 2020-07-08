package mk.ukim.finki.organisation.payments.port.rest;


import mk.ukim.finki.organisation.payments.application.Clients;
import mk.ukim.finki.organisation.payments.domain.model.Client;
import mk.ukim.finki.organisation.payments.domain.model.ClientId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
 class ClientsController {
private final Clients clients;


    ClientsController(Clients clients) {
        this.clients = clients;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable("id") String clientId) {
        return clients.findById(new ClientId(clientId))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Client> findAll() {
        return clients.findAll();
    }
}
