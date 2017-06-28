/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alexia.pereira
 */
@Service
public class GeneroService {

    @Autowired
    GeneroRepository repositorio;

    public Iterable<Genero> list() {
        return repositorio.findAll();
    }
    
    public Genero create(Genero genero) {
        return repositorio.save(genero);
    }
    
    public Genero update (Genero genero) {
        return repositorio.save(genero);
    }
    
    public void delete (Genero genero) {
        repositorio.delete(genero);
    }
    
}
