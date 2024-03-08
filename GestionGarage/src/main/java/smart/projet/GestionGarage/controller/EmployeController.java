package smart.projet.GestionGarage.controller;
import smart.projet.GestionGarage.entity.*;
import smart.projet.GestionGarage.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/employes")
public class EmployeController {
    @Autowired
    private EmployeService employeService;


    @PostMapping("/donner-ticket/{role}")
    public String donnerTicket(@PathVariable String role, @RequestBody Employe employe) {
        if ("donneur".equals(role)) { // Vérifie le rôle de l'employé
            try {
                employeService.donnerTicket(employe);
                return "Ticket donné avec succès.";
            } catch (IllegalStateException e) {
                return "Impossible de donner un ticket: " + e.getMessage();
            }
        } else {
            return "Seuls les employés avec le rôle de donneur peuvent donner un ticket.";
        }
    }


    @PostMapping("/annuler-ticket/{role}")
    public String annulerTicket(@PathVariable String role, @RequestBody Employe employe) {
        if ("donneur".equals(role)) { // Vérifie le rôle de l'employé
            try {
                employeService.annulerTicket(employe);
                return "Ticket annulé avec succès.";
            } catch (IllegalStateException e) {
                return "Impossible d'annuler un ticket: " + e.getMessage();
            }
        } else {
            return "Seuls les employés avec le rôle de donneur peuvent annuler un ticket.";
        }
    }
}
