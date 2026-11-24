package drivenow.app.service;

import drivenow.app.model.Car;
import drivenow.app.model.Reservation;
import drivenow.app.model.User;
import drivenow.app.repository.CarRepository;
import drivenow.app.repository.ReservationRepository;
import drivenow.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private UserRepository userRepository;

    public Reservation criarReserva(Long userId, Long carId, Reservation novaReserva) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new RuntimeException("Carro não encontrado"));

        if (!car.getAvailable()) {
            throw new RuntimeException("Este veículo não está disponível no momento.");
        }

        // Calcula a quantidade de dias da locação
        long dias = ChronoUnit.DAYS.between(novaReserva.getStartDate(), novaReserva.getEndDate());
        if (dias <= 0) {
            throw new RuntimeException("A data de término deve ser posterior à data de início.");
        }

        double precoTotal = dias * car.getDailyPrice();

        novaReserva.setUser(user);
        novaReserva.setCar(car);
        novaReserva.setTotalPrice(precoTotal);
        novaReserva.setStatus("ATIVA");

        // Atualiza o status do carro para indisponível
        car.setAvailable(false);
        carRepository.save(car);

        return reservationRepository.save(novaReserva);
    }
}
