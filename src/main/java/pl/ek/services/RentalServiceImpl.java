package pl.ek.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ek.domain.Rental;
import pl.ek.repositories.RentalRepository;

import java.util.List;

@Service
public class RentalServiceImpl implements RentalService {

    @Autowired
    private RentalRepository rentalRepository;


    @Override
    public Rental save(Rental rental) {
        Rental rent= new Rental();
        rent= rentalRepository.save(rental);
        return rent;
    }

    @Override
    public List<Rental> findAll() {
        return rentalRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        rentalRepository.delete(id);
    }
}
