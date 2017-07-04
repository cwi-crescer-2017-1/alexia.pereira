package br.com.crescer.redesocial.Controller;

import br.com.crescer.redesocial.Entity.Curtidas;
import br.com.crescer.redesocial.Service.CurtidasService;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alexia.pereira
 */
@RestController
@RequestMapping("/curtidas")
public class CurtidasController {
    @Autowired
    CurtidasService service;

    @GetMapping
    public Iterable<Curtidas> findAll() {
        return service.findAll();
    }

    @PostMapping
    public Curtidas save(@RequestBody Curtidas curtidas) {
        curtidas.setIdCurtida(1l);
        return service.save(curtidas);
    }

    @DeleteMapping
    public void remove(@RequestBody Curtidas curtidas) {
        service.remove(curtidas);
    }

    @GetMapping(value = "/{id}")
    public Curtidas loadById(@PathVariable Long id) {
        return service.loadById(id);
    }

    @GetMapping(value = "/post/{idPost}")
    public Set<Curtidas> buscarPorUsuario(@PathVariable Long idPost) {
        return service.loadByPost(idPost);
    }

}
