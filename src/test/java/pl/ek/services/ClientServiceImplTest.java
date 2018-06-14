package pl.ek.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.ek.DataToTestRepository;
import pl.ek.domain.Client;
import pl.ek.repositories.ClientRepository;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(value = MockitoJUnitRunner.class)
public class ClientServiceImplTest {

    private DataToTestRepository dataToTestRepository;
    private Client client;

    @InjectMocks
    private ClientServiceImpl clientService;

    @Mock
    private ClientRepository clientRepository;

    @Before
    public void init() {
        dataToTestRepository = new DataToTestRepository();
        client = dataToTestRepository.clientList().get(0);
    }

    @Test
    public void save() {
        when(clientRepository.save(client)).thenReturn(client);
        assertEquals(client, clientService.save(client));
    }

    @Test
    public void findAll() {
        when(clientRepository.findAll()).thenReturn(dataToTestRepository.clientList());
        assertEquals(2, clientService.findAll().size());
    }

    @Test
    public void update() {
//        when(clientRepository.update(client)).thenReturn(client);
//        assertEquals(client, clientService.update(client));
    }

    @Test
    public void findOne() {
        when(clientRepository.findOne(1L)).thenReturn(client);
        assertEquals(client, clientService.findOne(1L));
    }

    @Test
    public void delete() {
    }

    @Test
    public void findBySurname() {
        when(clientRepository.findBySurname("kot")).thenReturn(dataToTestRepository.clientList());
        assertEquals(2, clientService.findBySurname("kot").size());
    }
}