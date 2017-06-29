package br.com.crescer.aula7.Controllers;

import br.com.crescer.aula7.Entidades.Funcionario;
import br.com.crescer.aula7.Services.FuncionarioService;
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
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    FuncionarioService service;

    @GetMapping
    public Iterable<Funcionario> findAll() {
        return service.findAll();
    }

    @PostMapping
    public Funcionario save(@RequestBody Funcionario funcionario) {
        return service.save(funcionario);
    }

    @PutMapping
    public Funcionario update(@RequestBody Funcionario funcionario) {
        return service.update(funcionario);
    }

    @DeleteMapping
    public void remove(@RequestBody Funcionario funcionario) {
        service.remove(funcionario);
    }

    @GetMapping(value = "/{id}")
    public Funcionario loadById(@PathVariable Long id) {
        return service.loadById(id);
    }

}
