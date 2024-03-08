package smart.projet.GestionGarage.dao;
import smart.projet.GestionGarage.entity.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User1, Long> {
    User1 findByUsername(String username);
}
