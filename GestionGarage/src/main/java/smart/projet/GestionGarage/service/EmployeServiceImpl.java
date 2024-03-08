package smart.projet.GestionGarage.service;
import smart.projet.GestionGarage.dao.*;
import smart.projet.GestionGarage.entity.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class EmployeServiceImpl implements EmployeService {

 
    @Autowired
    private EmployeRepository employeRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public void donnerTicket(Employe employe) {
        if (employe.getRole() != null && employe.getRole().equals("donneur")) {
            // Logique pour donner un ticket
            Ticket nouveauTicket = new Ticket();
            nouveauTicket.setDateReservation(LocalDate.now());
            ticketRepository.save(nouveauTicket);
            System.out.println(employe.getNom() + " donne un ticket.");
        } else {
            throw new IllegalStateException("L'employé n'a pas le rôle approprié pour donner un ticket.");
        }
    }

    @Override
    public void annulerTicket(Employe employe) {
        if (employe.getRole() != null && employe.getRole().equals("donneur")) {
            // Logique pour annuler un ticket
            List<Ticket> tickets = ticketRepository.findAll();
            if (!tickets.isEmpty()) {
                Ticket dernierTicket = tickets.get(tickets.size() - 1);
                ticketRepository.delete(dernierTicket);
                System.out.println(employe.getNom() + " annule un ticket.");
            } else {
                System.out.println("Aucun ticket à annuler.");
            }
        } else {
            throw new IllegalStateException("L'employé n'a pas le rôle approprié pour annuler un ticket.");
        }
    }
}
