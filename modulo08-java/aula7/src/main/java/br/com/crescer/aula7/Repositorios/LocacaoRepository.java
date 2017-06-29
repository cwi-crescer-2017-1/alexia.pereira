package br.com.crescer.aula7.Repositorios;

import br.com.crescer.aula7.Entidades.Locacao;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author alexia.pereira
 */
public interface LocacaoRepository extends PagingAndSortingRepository<Locacao, Long> {

}
