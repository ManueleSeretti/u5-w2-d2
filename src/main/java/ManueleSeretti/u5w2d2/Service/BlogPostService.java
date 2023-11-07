package ManueleSeretti.u5w2d2.Service;

import ManueleSeretti.u5w2d2.Entities.BlogPost;
import ManueleSeretti.u5w2d2.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

@Service
public class BlogPostService {
    private List<BlogPost> post = new ArrayList<>();

    public BlogPost save(BlogPost body) {
        Random rndm = new Random();
        body.setId(rndm.nextInt(100, 999));
        this.post.add(body);
        return body;
    }

    public List<BlogPost> getPost() {
        return this.post;
    }

    public BlogPost findById(long id) {
        BlogPost b = null;
        for (BlogPost p : this.post) {
            if (p.getId() == id) {
                b = p;
            }
        }
        if (b == null) {
            throw new NotFoundException(id);
        } else {
            return b;
        }
    }

    public void findByIdAndDelete(long id) {
        ListIterator<BlogPost> iterator = this.post.listIterator();

        while (iterator.hasNext()) {
            BlogPost current = iterator.next();
            if (current.getId() == id) {
                iterator.remove();
            }
        }
    }

    public BlogPost findByIdAndUpdate(long id, BlogPost body) {
        BlogPost found = null;

        for (BlogPost p : this.post) {
            if (p.getId() == id) {
                found = p;
                found.setId(id);
                found.setCover(body.getCover());
                found.setTitle(body.getTitle());
                found.setCategory(body.getCategory());
                found.setContenuto(body.getContenuto());
                found.setTempoLettura(body.getTempoLettura());

            }
        }
        if (found == null) {
            throw new NotFoundException(id);
        } else {
            return found;
        }
    }
}
