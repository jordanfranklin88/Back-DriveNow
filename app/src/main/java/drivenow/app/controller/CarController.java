package drivenow.app.controller;

import drivenow.app.model.Car;
import drivenow.app.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public ResponseEntity<List<Car>> listarDisponiveis() {
        return ResponseEntity.ok(carService.listarCarrosDisponiveis());
    }

    @PostMapping
    public ResponseEntity<Car> cadastrarCarro(@RequestBody Car car) {
        return ResponseEntity.ok(carService.salvarCarro(car));
    }
}