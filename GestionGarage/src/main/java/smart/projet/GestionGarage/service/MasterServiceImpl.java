package smart.projet.GestionGarage.service;
import smart.projet.GestionGarage.entity.*;
import smart.projet.GestionGarage.dao.*;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MasterServiceImpl implements MasterService {

    @Autowired
    private EmployeRepository employeRepository;

    @Autowired
    private VoitureRepository voitureRepository;

    @Override
    public void ajouterEmploye(Employe employe) {
        // Logique pour ajouter un employé
        employeRepository.save(employe);
    }

    @Override
    public void supprimerEmploye(Long id) {
        // Logique pour supprimer un employé par son ID
        employeRepository.deleteById(id);
    }

    @Override
    public void modifierEmploye(Long id, Employe employe) {
        // Logique pour modifier un employé par son ID
        if (employeRepository.existsById(id)) {
            employe.setId(id);
            employeRepository.save(employe);
        } else {
            throw new IllegalArgumentException("L'employé avec l'ID " + id + " n'existe pas.");
        }
    }

    @Override
    public void enregistrerVoiture(String nomClient, String matricule) {
        // Logique pour enregistrer une voiture dans le garage
        Voiture voiture = new Voiture();
        voiture.setNomClient(nomClient);
        voiture.setMatricule(matricule);
        voitureRepository.save(voiture);
        System.out.println("Voiture enregistrée dans le garage.");
    }

    @Override
    public void supprimerVoiture(String voitureId) {
        Long id = Long.parseLong(voitureId);
        if (voitureRepository.existsById(id)) {
            voitureRepository.deleteById(id);
            System.out.println("Voiture supprimée du garage.");
        } else {
            throw new IllegalArgumentException("La voiture avec l'ID " + id + " n'existe pas.");
        }
    }
}
