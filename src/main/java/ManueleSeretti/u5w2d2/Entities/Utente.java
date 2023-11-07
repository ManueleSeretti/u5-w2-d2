package ManueleSeretti.u5w2d2.Entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Utente {
    private long id;
    private String name;
    private String cognome;
    private String email;
    private LocalDate data;
    private String avatar;

}
