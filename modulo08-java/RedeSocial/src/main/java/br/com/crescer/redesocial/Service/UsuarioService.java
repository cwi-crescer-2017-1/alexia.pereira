package br.com.crescer.redesocial.Service;

import br.com.crescer.redesocial.Entity.Usuario;
import br.com.crescer.redesocial.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alexia.pereira
 */
@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    public Iterable<Usuario> findAll() {
        return repository.findAll();
    }

    public Usuario save(Usuario cliente) {
        return repository.save(cliente);
    }

    public Usuario update(Usuario cliente) {
        return repository.save(cliente);
    }

    public void remove(Usuario cliente) {
        repository.delete(cliente);
    }

    public Usuario loadById(Long id) {
        return repository.findOne(id);
    }

}
