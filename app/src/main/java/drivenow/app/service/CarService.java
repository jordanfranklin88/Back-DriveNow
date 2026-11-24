package drivenow.app.service;

import drivenow.app.model.Car;
import drivenow.app.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> listarCarrosDisponiveis() {
        return carRepository.findByAvailableTrue();
    }

    public Car salvarCarro(Car car) {
        return carRepository.save(car);
    }
}
