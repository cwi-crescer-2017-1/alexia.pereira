package br.com.crescer.redesocial.Repository;

import br.com.crescer.redesocial.Entity.Solicitacao;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author A
 */
public interface SolicitacaoRepository extends PagingAndSortingRepository<Solicitacao, Long> {
    
}
