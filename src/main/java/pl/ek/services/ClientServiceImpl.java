package pl.ek.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ek.domain.Client;
import pl.ek.repositories.ClientRepository;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void save(Client client) {
        client.getClientAddress().setClient(client);
        client.getClientContact().setClient(client);
        clientRepository.save(client);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public void update(Client client) {
        clientRepository.save(client);
    }

    @Override
    public Client findOne(Long id) {
        return clientRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        clientRepository.delete(id);
    }

    @Override
    public List<Client> findBySurname(String surname) {
        return clientRepository.findBySurname(surname);
    }
}
