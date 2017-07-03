package br.com.crescer.redesocial.Controller;

import br.com.crescer.redesocial.Entity.Post;
import br.com.crescer.redesocial.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alexia.pereira
 */
@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostService service;

    @GetMapping
    public Iterable<Post> findAll() {
        return service.findAll();
    }

    @PostMapping
    public Post save(@RequestBody Post post) {
        post.setIdPost(0l);
        return service.save(post);
    }

    @PutMapping
    public Post update(@RequestBody Post post) {
        return service.update(post);
    }

    @DeleteMapping
    public void remove(@RequestBody Post post) {
        service.remove(post);
    }

    @GetMapping(value = "/{id}")
    public Post loadById(@PathVariable Long id) {
        return service.loadById(id);
    }

    @GetMapping(value = "/usuario/{idUsuario}")
    public Page<Post> buscarPorUsuario(@PathVariable Long idUsuario, @RequestParam int pagina, int quantidade) {
        return service.loadByUsuario(idUsuario, pagina, quantidade);
    }
    
    @GetMapping(value = "/amigos/{idUsuario}")
    public Page<Post> buscarPorAmigos(@PathVariable Long idUsuario, @RequestParam int pagina, int quantidade) {
        return service.loadFriendsPost(idUsuario, pagina, quantidade);
    }
    
}
