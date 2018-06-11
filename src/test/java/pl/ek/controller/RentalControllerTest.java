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
import pl.ek.domain.Rental;
import pl.ek.services.CarService;
import pl.ek.services.ClientService;
import pl.ek.services.RentalService;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class RentalControllerTest {

    @InjectMocks
    private RentalController rentalController;

    @Mock
    private RentalService rentalService;
    @Mock
    private ClientService clientService;
    @Mock
    private CarService carService;

    private MockMvc mockMvc;

    DataToTestRepository dataToTestRepository= new DataToTestRepository();

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(rentalController).build();
        when(rentalService.findAll()).thenReturn(dataToTestRepository.rentalList());
    }

    @Test
    public void start() {
    }

    @Test
    public void findAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/rental/showAll"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(view().name("rentalHome"))
                .andExpect(MockMvcResultMatchers.view().name("rentalHome"));
    }

    @Test
    public void showForm() throws Exception {
        when(carService.findAll()).thenReturn(dataToTestRepository.carList());
        when(clientService.findAll()).thenReturn(dataToTestRepository.clientList());
        mockMvc.perform(MockMvcRequestBuilders.get("/rental/add"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(model().attribute("rental", new Rental()))
                .andExpect(MockMvcResultMatchers.view().name("rentalForm"));
    }

    @Test
    public void add() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/rental/add"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(model().attribute("rental", dataToTestRepository.rentalList().get(0)))
                .andExpect(model().attribute("rents", dataToTestRepository.rentalList()))
                .andExpect(MockMvcResultMatchers.view().name("rentalHome"));
    }
}