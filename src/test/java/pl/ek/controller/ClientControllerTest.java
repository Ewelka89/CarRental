package pl.ek.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.ek.DataToTestRepository;
import pl.ek.domain.Client;
import pl.ek.services.ClientService;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class ClientControllerTest {

    @InjectMocks
    private ClientController clientController;

    @Mock
    private ClientService clientService ;

    private MockMvc mockMvc;

    DataToTestRepository dataToTestRepository= new DataToTestRepository();

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(clientController).build();
    }

    @Test
    public void findAll() throws Exception {
        when(clientService.findAll()).thenReturn(dataToTestRepository.clientList());
        mockMvc.perform(MockMvcRequestBuilders.get("/client/showAll"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(view().name("clientHome"))
                .andExpect(MockMvcResultMatchers.view().name("clientHome"));
    }

    @Test
    public void add() {
    }

    @Test
    public void showForm() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/client/add"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(model().attribute("client", new Client()))
                .andExpect(view().name("clientForm"))
                .andExpect(MockMvcResultMatchers.view().name("clientForm"));
    }

    @Test
    public void findBySurname() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/client/showFinder"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(model().attribute("client", new Client()))
                .andExpect(view().name("clientFinder"));
    }

    @Test
    public void clientWithSurname() throws Exception {
        when(clientService.findBySurname("kot")).thenReturn(dataToTestRepository.clientList());
        mockMvc.perform(MockMvcRequestBuilders.get("/client/findBySurname?surname=kot"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(model().attribute("clients", dataToTestRepository.clientList()))
                .andExpect(view().name("clientHome"));
    }

    @Test
    public void delete() {
    }

    @Test
    public void showDetails() throws Exception {
        when(clientService.findOne(1L)).thenReturn(dataToTestRepository.clientList().get(0));
        mockMvc.perform(MockMvcRequestBuilders.get("/client/details?id=1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(model().attribute("client", dataToTestRepository.clientList().get(0)))
                .andExpect(view().name("clientDetails"));
    }

    @Test
    public void showrentals() throws Exception {
        when(clientService.findOne(1L)).thenReturn(dataToTestRepository.clientList().get(0));
        mockMvc.perform(MockMvcRequestBuilders.get("/client/rentals?id=1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(model().attribute("client", dataToTestRepository.clientList().get(0)))
                .andExpect(view().name("clientRentals"));
    }

    @Test
    public void update() {
    }

    @Test
    public void showFormUpdate() throws Exception {
        when(clientService.findOne(1L)).thenReturn(dataToTestRepository.clientList().get(0));
        mockMvc.perform(MockMvcRequestBuilders.get("/client/update?id=1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(model().attribute("client", dataToTestRepository.clientList().get(0)))
                .andExpect(view().name("clientUpdate"));
    }
}