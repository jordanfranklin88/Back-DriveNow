package drivenow.app.repository;

import drivenow.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Superpoder do Spring: Ele cria a query SQL de busca só pelo nome do método!
    Optional<User> findByEmail(String email);
    Optional<User> findByCnh(String cnh);
}