package br.com.crescer.redesocial.Service;

import br.com.crescer.redesocial.Entity.Post;
import br.com.crescer.redesocial.Entity.Usuario;
import br.com.crescer.redesocial.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

/**
 *
 * @author alexia.pereira
 */
@Service
public class PostService {

    @Autowired
    PostRepository repository;
    
    @Autowired
    UsuarioService usuarioService;

    public Iterable<Post> findAll() {
        return repository.findAll();
    }

    public Post save(Post post) {
        return repository.save(post);
    }

    public Post update(Post post) {
        return repository.save(post);
    }

    public void remove(Post post) {
        repository.delete(post);
    }

    public Post loadById(Long id) {
        return repository.findOne(id);
    }

    public Page<Post> loadByUsuario(Long idUsuario, int pagina, int tamanho) {
        Usuario donoDoPost = usuarioService.loadById(idUsuario);
        Sort ordenador = new Sort(new Order(Direction.DESC, "dataPublicacao"));
        return repository.findByUsuario(donoDoPost, new PageRequest(pagina, tamanho, ordenador));
    }

}
