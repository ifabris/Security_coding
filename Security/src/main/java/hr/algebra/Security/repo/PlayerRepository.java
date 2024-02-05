package hr.algebra.Security.repo;

import hr.algebra.Security.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PlayerRepository extends JpaRepository<Player, Long> {

}
