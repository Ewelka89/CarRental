package pl.ek.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ek.domain.Car;
import pl.ek.repositories.CarRepository;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public void save(Car car) {
        carRepository.save(car);
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public Car findOne(Long id) {
        return carRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        carRepository.delete(id);
    }

    @Override
    public List<Car> findByBrand(String brand) {
        return carRepository.findByBrand(brand);
    }

}
