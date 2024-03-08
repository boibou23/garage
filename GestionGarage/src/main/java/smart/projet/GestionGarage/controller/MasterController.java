package smart.projet.GestionGarage.controller;
import smart.projet.GestionGarage.entity.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

import smart.projet.GestionGarage.service.MasterService;


@RestController
@RequestMapping("/master")
public class MasterController {

    @Autowired
    private MasterService masterService;

    @PostMapping("/ajouter-employe")
    public String ajouterEmploye(@RequestBody Employe employe) {
        masterService.ajouterEmploye(employe);
        return "Employé ajouté avec succès.";
    }

    @DeleteMapping("/supprimer-employe/{id}")
    public String supprimerEmploye(@PathVariable Long id) {
        masterService.supprimerEmploye(id);
        return "Employé supprimé avec succès.";
    }

    @PutMapping("/modifier-employe/{id}")
    public String modifierEmploye(@RequestBody Employe employe) {
        Employe employee = new Employe();
      //  employee.setId(id);
        employee.setNom(employe.getNom());
        employee.setRole(employe.getRole());
       // masterService.modifierEmploye(id);
        return "Employé modifié avec succès.";
    }

    @PostMapping("/enregistrer-voiture")
    public String enregistrerVoiture(@RequestBody Map<String, String> requestBody) {
        String nomClient = requestBody.get("nomClient");
        String matricule = requestBody.get("matricule");
        masterService.enregistrerVoiture(nomClient, matricule);
        return "Voiture enregistrée avec succès.";
    }

    @DeleteMapping("/supprimer-voiture/{voitureId}")
    public String supprimerVoiture(@PathVariable String voitureId) {
        masterService.supprimerVoiture(voitureId);
        return "Voiture supprimée avec succès.";
    }
}