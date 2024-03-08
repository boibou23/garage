package smart.projet.GestionGarage.service;
import java.util.Optional;

import smart.projet.GestionGarage.entity.*;

public interface MasterService {
    void ajouterEmploye(Employe employe);
    void supprimerEmploye(Long id);
    void modifierEmploye(Long id, Employe employe);
    void enregistrerVoiture(String nomClient, String matricule);
    void supprimerVoiture(String voitureId);
}
