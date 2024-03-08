package smart.projet.GestionGarage.service;

import smart.projet.GestionGarage.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import lombok.AllArgsConstructor;
import smart.projet.GestionGarage.dao.ReservationTicketRepository;
import smart.projet.GestionGarage.dao.UserRepository;


@Service

public class ReservationTicketServiceImpl implements ReservationTicketService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReservationTicketRepository reservationTicketRepository;

    @Override
    public void makeReservation(String username) {
        // Rechercher l'utilisateur dans la base de données
        User1 user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UserNotFoundException("User with username " + username + " not found.");
        }
}

}