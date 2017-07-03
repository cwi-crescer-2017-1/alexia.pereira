package br.com.crescer.redesocial.Repository;

import br.com.crescer.redesocial.Entity.Post;
import br.com.crescer.redesocial.Entity.Usuario;
import java.util.Set;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author alexia.pereira
 */
public interface PostRepository extends PagingAndSortingRepository<Post, Long> {

    Page<Post> findByUsuario(Usuario usuario, Pageable pg);

    Page<Post> findByUsuario(Set<Usuario> usuarios, Pageable pg);
}
