package pl.ek.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.ek.domain.Rental;

import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Long> {
    @Override
    List<Rental> findAll();
    Rental save(Rental rental);
}
