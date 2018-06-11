package pl.ek.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.ek.DataToTestRepository;
import pl.ek.repositories.RentalRepository;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(value = MockitoJUnitRunner.class)
public class RentalServiceImplTest {

    @InjectMocks
    private RentalServiceImpl rentalService;

    @Mock
    private RentalRepository rentalRepository;

    DataToTestRepository dataToTestRepository = new DataToTestRepository();


    @Test
    public void save() {
        assertEquals(dataToTestRepository.rentalList().get(0), rentalService.save(dataToTestRepository.rentalList().get(0)));
    }

    @Test
    public void findAll() {
        when(rentalRepository.findAll()).thenReturn(dataToTestRepository.rentalList());
        assertEquals(1, rentalService.findAll().size());
    }

    @Test
    public void delete() {
    }
}