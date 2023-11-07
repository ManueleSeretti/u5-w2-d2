package ManueleSeretti.u5w2d2.Controller;

import ManueleSeretti.u5w2d2.Entities.BlogPost;
import ManueleSeretti.u5w2d2.Service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/BlogPost")
public class BlogController {
    @Autowired
    private BlogPostService postService;

    // 1. GET http://localhost:3001/post (+ query params opzionali)
    @GetMapping("")
    public List<BlogPost> getUtente() {
        return postService.getPost();
    }

    // 2. POST http://localhost:3001/post (+ body)
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED) // <-- 201
    public BlogPost saveUtente(@RequestBody BlogPost body) {
        return postService.save(body);
    }

    // 3. GET http://localhost:3001/post/:id
    @GetMapping("/{id}")
    public BlogPost findById(@PathVariable int id) {
        return postService.findById(id);
    }

    // 4. PUT http://localhost:3001/post/:id (+ body)
    @PutMapping("/{id}")
    public BlogPost findByIdAndUpdate(@PathVariable int id, @RequestBody BlogPost body) {
        return postService.findByIdAndUpdate(id, body);
    }

    // 5. DELETE http://localhost:3001/post/:id
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // <-- 204 NO CONTENT
    public void findByIdAndDelete(@PathVariable int id) {
        postService.findByIdAndDelete(id);
    }
}
