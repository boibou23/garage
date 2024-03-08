package smart.projet.GestionGarage.service;

public interface UserService {
    void createAccount(String username, String password, String email);
    boolean loginUser(String username, String password);
}
