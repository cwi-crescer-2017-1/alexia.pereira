package br.com.crescer.redesocial.Repository;

import br.com.crescer.redesocial.Entity.Post;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author alexia.pereira
 */
public interface PostRepository extends PagingAndSortingRepository<Post, Long> {

}
