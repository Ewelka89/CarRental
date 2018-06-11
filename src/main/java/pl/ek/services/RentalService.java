package pl.ek.services;

import pl.ek.domain.Rental;

import java.util.List;

public interface RentalService {
    Rental save (Rental rental);
    List<Rental> findAll();
    void delete (Long id);
}
