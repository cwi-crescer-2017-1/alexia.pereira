package br.com.crescer.redesocial.Repository;

import br.com.crescer.redesocial.Entity.Curtidas;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.crescer.redesocial.Entity.Post;
import java.util.Set;

/**
 *
 * @author alexia.pereira
 */
public interface CurtidasRepository extends PagingAndSortingRepository<Curtidas, Long> {

    public Set<Curtidas> findByPost(Post post);
    
}
