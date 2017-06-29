package br.com.crescer.aula7.Services;

import br.com.crescer.aula7.Entidades.Genero;
import br.com.crescer.aula7.Repositorios.GeneroRepository;
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

    public Iterable<Genero> findAll() {
        return repositorio.findAll();
    }

    public Genero save(Genero genero) {
        return repositorio.save(genero);
    }

    public Genero update(Genero genero) {
        return repositorio.save(genero);
    }

    public void remove(Genero genero) {
        repositorio.delete(genero);
    }

    public Genero loadById(Long id) {
        return repositorio.findOne(id);
    }

}
