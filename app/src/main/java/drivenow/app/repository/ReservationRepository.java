package drivenow.app.repository;

import drivenow.app.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    // Traz todo o histórico de locações de um usuário específico
    List<Reservation> findByUserId(Long userId);
}