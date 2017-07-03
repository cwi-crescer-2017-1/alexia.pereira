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

//    @Query("SELECT * FROM POST P INNER JOIN USUARIO U ON U.ID_USUARIO = P.ID_USUARIO WHERE ID")
    Page<Post> findByUsuarioIn(Set<Usuario> usuarios, Pageable pg);
}
