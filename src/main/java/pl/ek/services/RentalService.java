package pl.ek.services;

import pl.ek.domain.Rental;

import java.util.List;

public interface RentalService {
    void save (Rental rental);
    List<Rental> findAll();
    void delete (Long id);
}
