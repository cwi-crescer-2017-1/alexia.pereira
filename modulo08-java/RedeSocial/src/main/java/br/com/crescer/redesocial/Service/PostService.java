package br.com.crescer.redesocial.Service;

import br.com.crescer.redesocial.Entity.Post;
import br.com.crescer.redesocial.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alexia.pereira
 */
@Service
public class PostService {

    @Autowired
    PostRepository repository;

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

}
