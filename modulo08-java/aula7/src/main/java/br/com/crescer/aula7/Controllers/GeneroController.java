package br.com.crescer.aula7.Controllers;

import br.com.crescer.aula7.Entidades.Genero;
import br.com.crescer.aula7.Services.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alexia.pereira
 */
@RestController
@RequestMapping("/genero")
public class GeneroController {

    @Autowired
    GeneroService service;

    @GetMapping
    public Iterable<Genero> findAll() {
        return service.findAll();
    }

    @PostMapping
    public Genero save(@RequestBody Genero genero) {
        return service.save(genero);
    }

    @PutMapping
    public Genero update(@RequestBody Genero genero) {
        return service.update(genero);
    }

    @DeleteMapping
    public void remove(@RequestBody Genero genero) {
        service.remove(genero);
    }

    @GetMapping(value = "/{id}")
    public Genero loadById(@PathVariable Long id) {
        return service.loadById(id);
    }

}
