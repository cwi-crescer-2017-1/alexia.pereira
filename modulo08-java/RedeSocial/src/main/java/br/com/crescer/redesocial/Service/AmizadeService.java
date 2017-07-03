package br.com.crescer.redesocial.Service;

import br.com.crescer.redesocial.Entity.Amizade;
import br.com.crescer.redesocial.Entity.Usuario;
import br.com.crescer.redesocial.Repository.AmizadeRepository;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author A
 */
@Service
public class AmizadeService {
    
    @Autowired
    AmizadeRepository repository;
    
    public Amizade save(Amizade amizade) {
        amizade.setIdAmizade(0l);
        this.saveInvertedAmizade(amizade);
        return repository.save(amizade);
    }

    private void saveInvertedAmizade(Amizade amizade) {
        Amizade amizadeInvertida = new Amizade();
        amizadeInvertida.setIdAmizade(1l);
        amizadeInvertida.setUsuario1(amizade.getUsuario2());
        amizadeInvertida.setUsuario2(amizade.getUsuario1());
        repository.save(amizadeInvertida);
    }
    
    public Set<Amizade> buscarAmigos (Usuario usuario) {
        return repository.findByUsuario1(usuario);
    }
    
}
