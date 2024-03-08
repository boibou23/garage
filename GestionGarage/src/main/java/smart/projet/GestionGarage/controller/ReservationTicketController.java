package smart.projet.GestionGarage.controller;
import smart.projet.GestionGarage.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import smart.projet.GestionGarage.service.ReservationTicketService;
import java.util.Map;

@RestController
public class ReservationTicketController {
    @Autowired
    private ReservationTicketService reservationTicketService;


    @PostMapping("/reservation")
    public ResponseEntity<String> makeReservation(@RequestBody Map<String, String> requestBody) {
        String username = requestBody.get("username");
        if (username != null) {
            try {
                reservationTicketService.makeReservation(username);
                return ResponseEntity.ok("Reservation successful.");
            } catch (UserNotFoundException e) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                return ResponseEntity.badRequest().body("Reservation failed: " + e.getMessage());
            }
        } else {
            return ResponseEntity.badRequest().body("Reservation failed: Required parameter 'username' is not present.");
        }
    }
}
