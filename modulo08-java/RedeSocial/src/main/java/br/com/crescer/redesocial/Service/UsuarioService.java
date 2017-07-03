package br.com.crescer.redesocial.Service;

import br.com.crescer.redesocial.Entity.Amizade;
import br.com.crescer.redesocial.Entity.Usuario;
import br.com.crescer.redesocial.Repository.UsuarioRepository;
import java.util.HashSet;
import java.util.Set;
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

    @Autowired
    AmizadeService amizadeService;

    public Iterable<Usuario> findAll() {
        return repository.findAll();
    }

    public Usuario save(Usuario usuario) {
        return repository.save(usuario);
    }

    public Usuario update(Usuario usuario) {
        return repository.save(usuario);
    }

    public void remove(Usuario usuario) {
        repository.delete(usuario);
    }

    public Usuario loadById(Long id) {
        return repository.findOne(id);
    }

    public void buscarAmigos(Usuario usuario) {
        Set<Amizade> amizades = amizadeService.buscarAmigos(usuario);
        for (Amizade amizade : amizades) {
            Usuario amigo = amizade.getUsuario2();
            usuario.getAmigos().add(amigo);
        }
    }

}
