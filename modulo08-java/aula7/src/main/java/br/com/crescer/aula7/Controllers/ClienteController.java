package br.com.crescer.aula7.Controllers;

import br.com.crescer.aula7.Entidades.Cliente;
import br.com.crescer.aula7.Services.ClienteService;
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
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService service;

    @GetMapping
    public Iterable<Cliente> findAll() {
        return service.findAll();
    }

    @PostMapping
    public Cliente save(@RequestBody Cliente cliente) {
        return service.save(cliente);
    }

    @PutMapping
    public Cliente update(@RequestBody Cliente cliente) {
        return service.update(cliente);
    }

    @DeleteMapping
    public void remove(@RequestBody Cliente cliente) {
        service.remove(cliente);
    }

    @GetMapping(value = "/{id}")
    public Cliente loadById(@PathVariable Long id) {
        return service.loadById(id);
    }

}
