package mk.ukim.finki.emt.organisation.projects.port.client;

import mk.ukim.finki.emt.organisation.projects.application.Clients;
import mk.ukim.finki.emt.organisation.projects.domain.model.Client;
import mk.ukim.finki.emt.organisation.projects.domain.model.ClientId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;

@Service
public class ClientsClient implements Clients {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientsClient.class);

    private final RestTemplate restTemplate;
    private final String serverUrl;

    ClientsClient(@Value("${app.product-catalog.url}") String serverUrl,
                         @Value("${app.product-catalog.connect-timeout-ms}") int connectTimeout,
                         @Value("${app.product-catalog.read-timeout-ms}") int readTimeout) {
        this.serverUrl = serverUrl;
        restTemplate = new RestTemplate();
        var requestFactory = new SimpleClientHttpRequestFactory();
        // Never ever do a remote call without a finite timeout!
        requestFactory.setConnectTimeout(connectTimeout);
        requestFactory.setReadTimeout(readTimeout);
        restTemplate.setRequestFactory(requestFactory);
    }
    private UriComponentsBuilder uri() {
        return UriComponentsBuilder.fromUriString(serverUrl);
    }
    @Override
    public List<Client> findAll() {
        try {
            return restTemplate.exchange(uri().path("/api/clients").build().toUri(), HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<Client>>() {
                    }).getBody();
        } catch (Exception ex) {
            LOGGER.error("Error retrieving clients", ex);
            return Collections.emptyList();
        }
    }

    @Override
    public Client findById(ClientId id) {
        try {
            return restTemplate.exchange(uri().path("/api/clients/"+id.getId()).build().toUri(), HttpMethod.GET, null,
                    new ParameterizedTypeReference<Client>() {
                    }).getBody();
        } catch (Exception ex) {
            LOGGER.error("Error retrieving client by id", ex);
            return null;
        }
    }
}
