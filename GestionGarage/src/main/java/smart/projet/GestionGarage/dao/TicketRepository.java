package smart.projet.GestionGarage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import smart.projet.GestionGarage.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>{
}
