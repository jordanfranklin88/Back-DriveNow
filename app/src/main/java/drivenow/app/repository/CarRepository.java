package drivenow.app.repository;

import drivenow.app.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    // Busca todos os carros que estão disponíveis para locação
    List<Car> findByAvailableTrue();
}