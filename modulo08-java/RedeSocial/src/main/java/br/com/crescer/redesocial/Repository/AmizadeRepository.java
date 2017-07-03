package br.com.crescer.redesocial.Repository;

import br.com.crescer.redesocial.Entity.Amizade;
import br.com.crescer.redesocial.Entity.Usuario;
import java.util.Set;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author A
 */
public interface AmizadeRepository extends PagingAndSortingRepository<Amizade, Long> {
    Set<Amizade> findByUsuario1 (Usuario usuario);
}
