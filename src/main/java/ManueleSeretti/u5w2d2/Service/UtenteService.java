package ManueleSeretti.u5w2d2.Service;

import ManueleSeretti.u5w2d2.Entities.Utente;
import ManueleSeretti.u5w2d2.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

@Service
public class UtenteService {
    private List<Utente> users = new ArrayList<>();

    public Utente save(Utente body) {
        Random rndm = new Random();
        body.setId(rndm.nextInt(100, 999));
        this.users.add(body);
        return body;
    }

    public List<Utente> getUtente() {
        return this.users;
    }

    public Utente findById(int id) {
        Utente u = null;
        for (Utente user : this.users) {
            if (user.getId() == id) {
                u = user;
            }
        }
        if (u == null) {
            throw new NotFoundException(id);
        } else {
            return u;
        }
    }

    public void findByIdAndDelete(int id) {
        ListIterator<Utente> iterator = this.users.listIterator();

        while (iterator.hasNext()) {
            Utente current = iterator.next();
            if (current.getId() == id) {
                iterator.remove();
            }
        }
    }

    public Utente findByIdAndUpdate(int id, Utente body) {
        Utente found = null;

        for (Utente user : this.users) {
            if (user.getId() == id) {
                found = user;
                found.setId(id);
                found.setName(body.getName());
                found.setCognome(body.getCognome());
                found.setEmail(body.getEmail());
                found.setAvatar(body.getAvatar());
                found.setData(body.getData());

            }
        }
        if (found == null) {
            throw new NotFoundException(id);
        } else {
            return found;
        }
    }
}

