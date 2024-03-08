package smart.projet.GestionGarage.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;



@Entity
@Getter
@Setter
@AllArgsConstructor
public class ReservationTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date reservationDate;

    @ManyToOne
    private User1 user;

    public ReservationTicket() {
    }
}
