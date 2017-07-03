package br.com.crescer.redesocial.Repository;

import br.com.crescer.redesocial.Entity.Usuario;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author alexia.pereira
 */
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long> {
    
    public Usuario findOneByEmail(String email);
    public int countByEmail(String email);
    
}
