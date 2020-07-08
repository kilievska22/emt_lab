package mk.ukim.finki.organisation.payments.application;

import mk.ukim.finki.organisation.payments.domain.model.Client;
import mk.ukim.finki.organisation.payments.domain.model.ClientId;
import mk.ukim.finki.organisation.payments.domain.repository.ClientsRepository;
import mk.ukim.finki.organisation.payments.integration.ProjectFinishedEvent;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class Clients {
    private final ClientsRepository clientsRepository;

    public Clients(ClientsRepository clientsRepository) {
        this.clientsRepository = clientsRepository;
    }

    @NonNull
    public List<Client> findAll() {
        return clientsRepository.findAll();
    }

    @NonNull
    public Optional<Client> findById(@NonNull ClientId clientId) {
        Objects.requireNonNull(clientId, "clientId must not be null");
        return clientsRepository.findById(clientId.getId());
    }

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void onProjectFinished(ProjectFinishedEvent event) {
        Client c = clientsRepository.findById(event.getClientId().getId()).orElseThrow(RuntimeException::new);
       c.changeStatus();
        clientsRepository.save(c);
    }
}
