package pl.ek.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.ek.DataToTestRepository;
import pl.ek.repositories.CarRepository;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(value = MockitoJUnitRunner.class)
public class CarServiceImplTest {

    @InjectMocks
    private CarServiceImpl carService;

    @Mock
    private CarRepository carRepository;

    DataToTestRepository dataToTestRepository= new DataToTestRepository();

    @Test
    public void save() {

    }

    @Test
    public void findAll() {
        when(carRepository.findAll()).thenReturn(dataToTestRepository.carList());
        assertEquals(2, carService.findAll().size());
    }

    @Test
    public void findOne() {
        when(carRepository.findOne(1L)).thenReturn(dataToTestRepository.carList().get(0));
        assertEquals(dataToTestRepository.carList().get(0), carService.findOne(1L));
    }

    @Test
    public void delete() {
    }

    @Test
    public void findByBrand() {
        when(carRepository.findByBrand("ford")).thenReturn(dataToTestRepository.carList());
        assertEquals(2, carService.findByBrand("ford").size());
    }
}