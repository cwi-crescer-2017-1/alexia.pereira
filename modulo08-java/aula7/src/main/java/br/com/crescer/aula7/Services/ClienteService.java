package br.com.crescer.aula7.Services;

import br.com.crescer.aula7.Entidades.Cliente;
import br.com.crescer.aula7.Repositorios.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alexia.pereira
 */
@Service
public class ClienteService {

    @Autowired
    ClienteRepository repositorio;

    public Iterable<Cliente> findAll() {
        return repositorio.findAll();
    }

    public Cliente save(Cliente cliente) {
        return repositorio.save(cliente);
    }

    public Cliente update(Cliente cliente) {
        return repositorio.save(cliente);
    }

    public void remove(Cliente cliente) {
        repositorio.delete(cliente);
    }

    public Cliente loadById(Long id) {
        return repositorio.findOne(id);
    }

}
