package smart.projet.GestionGarage.service;
import smart.projet.GestionGarage.entity.*;

import smart.projet.GestionGarage.dao.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void createAccount(String username, String password, String email) {
        User1 user = new User1(username, password, email);
        userRepository.save(user);
    }

    @Override
    public boolean loginUser(String username, String password) {
        User1 user = userRepository.findByUsername(username);
        return user != null;
    }
}
