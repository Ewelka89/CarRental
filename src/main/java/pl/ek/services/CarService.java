package pl.ek.services;

import pl.ek.domain.Car;

import java.util.List;

public interface CarService {

    Car save (Car car);
    List<Car> findAll();
    Car findOne (Long id);
    void delete (Long id);

    List<Car> findByBrand(String brand);

}
