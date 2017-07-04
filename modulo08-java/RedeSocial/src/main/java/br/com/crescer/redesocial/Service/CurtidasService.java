package br.com.crescer.redesocial.Service;

import br.com.crescer.redesocial.Entity.Curtidas;
import br.com.crescer.redesocial.Entity.Post;
import br.com.crescer.redesocial.Repository.CurtidasRepository;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Vanderleia Pereira
 */
@Service
public class CurtidasService {

    @Autowired
    CurtidasRepository repository;

    @Autowired
    PostService postService;

    public Iterable<Curtidas> findAll() {
        return repository.findAll();
    }

    public Curtidas save(Curtidas curtidas) {
        Curtidas stream = new Curtidas();
        stream.setIdCurtida(curtidas.getIdCurtida());
        stream.setPost(curtidas.getPost());
        stream.setUsuario(curtidas.getUsuario());
        List<Curtidas> usuarioJaCurtiu
                = stream.getPost().getCurtidasSet().stream()
                        .filter(c -> c.getUsuario().getIdUsuario() == curtidas.getUsuario().getIdUsuario())
                        .collect(Collectors.toList());

        if (usuarioJaCurtiu.size() > 0) {
            this.remove(curtidas);
            return null;
        }
        
        Curtidas retorno = repository.save(curtidas);
        return retorno;
    }

    public Curtidas update(Curtidas curtidas) {
        return repository.save(curtidas);
    }

    public void remove(Curtidas curtidas) {
        List<Curtidas> usuarioJaCurtiu
                = curtidas.getPost().getCurtidasSet().stream()
                        .filter(c -> c.getUsuario().getIdUsuario() == curtidas.getUsuario().getIdUsuario())
                        .collect(Collectors.toList());;
        if (usuarioJaCurtiu.size() < 1) {
            this.save(curtidas);
        } else {
            Curtidas curtidaASerDeletada = this.loadById(usuarioJaCurtiu.get(0).getIdCurtida());
            repository.delete(curtidaASerDeletada);
        }
    }

    public Curtidas loadById(Long id) {
        return repository.findOne(id);
    }

    public Set<Curtidas> loadByPost(Long idPost) {
        Post post = postService.loadById(idPost);
        return repository.findByPost(post);
    }

}
