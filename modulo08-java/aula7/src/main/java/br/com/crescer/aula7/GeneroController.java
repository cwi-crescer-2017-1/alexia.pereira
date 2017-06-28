/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
    public Iterable<Genero> list() {
        return service.list();
    }
    
    @PostMapping
    public Genero create(@RequestBody Genero genero) {
        return service.create(genero);
    }
    
    @PutMapping
    public Genero update(@RequestBody Genero genero) {
        return service.update(genero);
    }
    
    @DeleteMapping
    public void delete (@RequestBody Genero genero) {
        service.delete(genero);
    }
    
}
