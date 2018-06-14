package pl.ek.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.ek.DataToTestRepository;
import pl.ek.domain.Car;
import pl.ek.repositories.CarRepository;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(value = MockitoJUnitRunner.class)
public class CarServiceImplTest {

    private DataToTestRepository dataToTestRepository;
    private Car car;

    @InjectMocks
    private CarServiceImpl carService;

    @Mock
    private CarRepository carRepository;

    @Before
    public void init() {
        dataToTestRepository = new DataToTestRepository();
        car = dataToTestRepository.carList().get(0);
    }

    @Test
    public void save() {
        when(carRepository.save(car)).thenReturn(car);
        assertEquals(car, carService.save(car));
    }

    @Test
    public void findAll() {
        when(carRepository.findAll()).thenReturn(dataToTestRepository.carList());
        assertEquals(2, carService.findAll().size());
    }

    @Test
    public void findOne() {
        when(carRepository.findOne(1L)).thenReturn(car);
        assertEquals(car, carService.findOne(1L));
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