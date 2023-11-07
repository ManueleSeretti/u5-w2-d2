package ManueleSeretti.u5w2d2.Controller;

import ManueleSeretti.u5w2d2.Entities.Utente;
import ManueleSeretti.u5w2d2.Service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Utente")
public class UtenteController {
    @Autowired
    private UtenteService usersService;

    @GetMapping("")
    public List<Utente> getUtente() {
        return usersService.getUtente();
    }

    // 2. POST http://localhost:3001/users (+ body)
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED) // <-- 201
    public Utente saveUtente(@RequestBody Utente body) {
        return usersService.save(body);
    }

    // 3. GET http://localhost:3001/users/:id
    @GetMapping("/{id}")
    public Utente findById(@PathVariable int id) {
        return usersService.findById(id);
    }

    // 4. PUT http://localhost:3001/users/:id (+ body)
    @PutMapping("/{id}")
    public Utente findByIdAndUpdate(@PathVariable int id, @RequestBody Utente body) {
        return usersService.findByIdAndUpdate(id, body);
    }

    // 5. DELETE http://localhost:3001/users/:id
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // <-- 204 NO CONTENT
    public void findByIdAndDelete(@PathVariable int id) {
        usersService.findByIdAndDelete(id);
    }
}
