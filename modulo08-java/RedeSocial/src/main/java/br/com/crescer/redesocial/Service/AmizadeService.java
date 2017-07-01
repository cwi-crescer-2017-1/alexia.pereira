package br.com.crescer.redesocial.Service;

import br.com.crescer.redesocial.Entity.Amizade;
import br.com.crescer.redesocial.Entity.Usuario;
import br.com.crescer.redesocial.Repository.AmizadeRepository;
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
        Usuario aux = amizade.getUsuario1();
        amizade.setUsuario1(amizade.getUsuario2());
        amizade.setUsuario2(aux);
        repository.save(amizade);
    }
    
}
