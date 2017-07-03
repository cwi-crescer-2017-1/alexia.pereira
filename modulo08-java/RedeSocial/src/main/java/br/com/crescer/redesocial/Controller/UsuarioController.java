package br.com.crescer.redesocial.Controller;

import br.com.crescer.redesocial.Controller.Exceptions.EmailJaCadastrado;
import br.com.crescer.redesocial.Entity.Usuario;
import br.com.crescer.redesocial.Service.UsuarioService;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alexia.pereira
 */
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @GetMapping
    public Iterable<Usuario> findAll() {
        return service.findAll();
    }

    @PostMapping
    public Usuario save(@RequestBody Usuario usuario) throws EmailJaCadastrado {
        usuario.setIdUsuario(0l);
        usuario.criptografarSenha();
        return service.save(usuario);
    }

    @PutMapping
    public Usuario update(@RequestBody Usuario usuario) {
        return service.update(usuario);
    }

    @DeleteMapping
    public void remove(@RequestBody Usuario usuario) {
        service.remove(usuario);
    }

    @GetMapping(value = "/{id}")
    public Usuario loadById(@PathVariable Long id) {
        return service.loadById(id);
    }

    @GetMapping(value = "/amigos/{id}")
    public Usuario loadFriends(@PathVariable Long id) {
        Usuario usuario = service.loadById(id);
        service.buscarAmigos(usuario);
        return usuario;
    }
    
    @GetMapping(value="buscar")
    public Set<Usuario> loadByName (@RequestParam String nome) {
        return service.buscarPorNome(nome);
    }

}
