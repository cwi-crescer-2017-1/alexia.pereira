package br.com.crescer.aula7.Controllers;

import br.com.crescer.aula7.Entidades.Locacao;
import br.com.crescer.aula7.Services.LocacaoService;
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
@RequestMapping("/locacao")
public class LocacaoController {

    @Autowired
    LocacaoService service;

    @GetMapping
    public Iterable<Locacao> findAll() {
        return service.findAll();
    }

    @PostMapping
    public Locacao save(@RequestBody Locacao locacao) {
        return service.save(locacao);
    }

    @PutMapping
    public Locacao update(@RequestBody Locacao locacao) {
        return service.update(locacao);
    }

    @DeleteMapping
    public void remove(@RequestBody Locacao locacao) {
        service.remove(locacao);
    }

    @GetMapping(value = "/{id}")
    public Locacao loadById(@PathVariable Long id) {
        return service.loadById(id);
    }

}
