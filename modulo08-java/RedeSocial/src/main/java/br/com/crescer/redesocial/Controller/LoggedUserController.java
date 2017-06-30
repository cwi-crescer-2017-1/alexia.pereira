package br.com.crescer.redesocial.Controller;

import br.com.crescer.redesocial.Entity.Usuario;
import br.com.crescer.redesocial.Repository.UsuarioRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author carloshenrique
 */
@RestController
@RequestMapping(LoggedUserController.PATH)
public class LoggedUserController {

    @Autowired
    UsuarioRepository repository;

    public static final String PATH = "/usuarioAtual";

    @GetMapping
    public Usuario getUserDetails(Authentication authentication) {
        return Optional.ofNullable(authentication)
                .map(Authentication::getPrincipal)
                .map(User.class::cast)
                .map(User::getUsername)
                .map(repository::findOneByEmail)
                .orElse(null);
    }
}
