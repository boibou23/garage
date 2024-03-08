package smart.projet.GestionGarage.controller;
import smart.projet.GestionGarage.entity.*;
import smart.projet.GestionGarage.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/employes")
public class EmployeController {
    @Autowired
    private EmployeService employeService;


    @PostMapping("/{role}/donner-ticket")
    public String donnerTicket(@RequestBody Employe employe) {
        if ("donneur".equals(employe.getRole())) { // Vérifie le rôle de l'employé
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

    @PostMapping("/annuler-ticket")
    public String annulerTicket(@RequestBody Employe employe) {
        try {
            employeService.annulerTicket(employe);
            return "Ticket annulé avec succès.";
        } catch (IllegalStateException e) {
            return "Impossible d'annuler un ticket: " + e.getMessage();
        }
    }
}
