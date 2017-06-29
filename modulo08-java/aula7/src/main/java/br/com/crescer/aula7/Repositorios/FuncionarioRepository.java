package br.com.crescer.aula7.Repositorios;

import br.com.crescer.aula7.Entidades.Funcionario;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author alexia.pereira
 */
public interface FuncionarioRepository extends PagingAndSortingRepository<Funcionario, Long> {

}
