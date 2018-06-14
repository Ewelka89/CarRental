package pl.ek.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.ek.DataToTestRepository;
import pl.ek.domain.Rental;
import pl.ek.repositories.RentalRepository;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(value = MockitoJUnitRunner.class)
public class RentalServiceImplTest {

    private DataToTestRepository dataToTestRepository;

    @InjectMocks
    private RentalServiceImpl rentalService;

    @Mock
    private RentalRepository rentalRepository;

    @Before
    public void init() {
        dataToTestRepository = new DataToTestRepository();
    }

    @Test
    public void save() {
        Rental rental = dataToTestRepository.rentalList().get(0);
        when(rentalRepository.save(rental)).thenReturn(rental);
        assertEquals(rental, rentalService.save(rental));
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