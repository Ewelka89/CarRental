package pl.ek.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.ek.domain.Client;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    @Override
    List<Client> findAll();
    List<Client> findBySurname(String surname);
    Client save(Client client);
}
