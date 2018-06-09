package pl.ek.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.ek.repositories.CarRepository;

@RunWith(value = MockitoJUnitRunner.class)
public class CarServiceImplTest {

    @InjectMocks
    private CarServiceImpl carService;

    @Mock
    private CarRepository carRepository;

    @Test
    public void save() {
    }

    @Test
    public void findAll() {
    }

    @Test
    public void findOne() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void findByBrand() {
    }
}