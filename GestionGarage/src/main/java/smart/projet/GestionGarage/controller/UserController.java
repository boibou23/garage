
package smart.projet.GestionGarage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import smart.projet.GestionGarage.service.UserService;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/createAccount")
    public String createAccount(@RequestBody Map<String, String> requestBody) {
        String username = requestBody.get("username");
        String password = requestBody.get("password");
        String email = requestBody.get("email");
        try {
            userService.createAccount(username, password, email);
            return "User registered successfully.";
        } catch (IllegalArgumentException e) {
            return "Registration failed: " + e.getMessage();
        }
    }
    @PostMapping("/login")
    public String loginUser(@RequestBody Map<String, String> requestBody) {
        String username = requestBody.get("username");
        String password = requestBody.get("password");
        boolean loginSuccessful = userService.loginUser(username, password);
        if (loginSuccessful) {
            return "Login successful.";
        } else {
            return "Login failed. Invalid username or password.";
        }
    }
}
