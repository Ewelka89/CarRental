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
import pl.ek.domain.Car;
import pl.ek.services.CarService;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class CarControllerTest {

    @InjectMocks
    private CarController carController;

    @Mock
    private CarService carService;

    private MockMvc mockMvc;

    private DataToTestRepository dataToTestRepository;

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(carController).build();
        dataToTestRepository= new DataToTestRepository();
    }

    @Test
    public void findAll() throws Exception {
        when(carService.findAll()).thenReturn(dataToTestRepository.carList());
        mockMvc.perform(MockMvcRequestBuilders.get("/car/showAll"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(view().name("carHome"))
                .andExpect(MockMvcResultMatchers.view().name("carHome"));
    }


    @Test
    public void showForm() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/car/add"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(model().attribute("car", new Car()))
                .andExpect(view().name("carForm"))
                .andExpect(MockMvcResultMatchers.view().name("carForm"));
    }

    @Test
    public void add() {
    }

    @Test
    public void deleteCar() {
    }

    @Test
    public void findCarByBrand() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/car/showFinder"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(model().attribute("car", new Car()))
                .andExpect(view().name("carFinder"));
    }

    @Test
    public void carsWithBrand() throws Exception {
        when(carService.findByBrand("ford")).thenReturn(dataToTestRepository.carList());
        mockMvc.perform(MockMvcRequestBuilders.get("/car/findByBrand?brand=ford"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(model().attribute("cars", dataToTestRepository.carList()))
                .andExpect(view().name("carHome"));
    }
}