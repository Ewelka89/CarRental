package pl.ek.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.ek.domain.Car;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    @Override
    List<Car> findAll();

    List<Car> findByBrand(String brand);

    Car save(Car car);
}
