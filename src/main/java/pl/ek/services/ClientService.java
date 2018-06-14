package pl.ek.services;

import pl.ek.domain.Client;

import java.util.List;

public interface ClientService {

    Client save (Client client);
    List<Client> findAll();
    void update (Client client);
    Client findOne (Long id);
    void delete (Long id);
    List<Client> findBySurname(String surname);
}
