package br.com.crescer.redesocial.Repository;

import br.com.crescer.redesocial.Entity.Solicitacao;
import br.com.crescer.redesocial.Entity.Usuario;
import java.util.Set;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author A
 */
public interface SolicitacaoRepository extends PagingAndSortingRepository<Solicitacao, Long> {
    Set<Solicitacao> findByUsuarioTarget(Usuario usuarioTarget);
}
