package br.com.crescer.redesocial.Security;

import br.com.crescer.redesocial.Entity.Usuario;
import br.com.crescer.redesocial.Repository.UsuarioRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author carloshenrique
 */
@Service
public class SocialUserDetailsService implements UserDetailsService {

    @Autowired
    UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username.isEmpty()) {
            throw new UsernameNotFoundException(String.format("Usuario com email =%s não encontrado", username));
        }
        Usuario usuario = repository.findOneByEmail(username);
        return new User(usuario.getEmail(), usuario.getSenha(), new ArrayList<GrantedAuthority>());
    }

}
