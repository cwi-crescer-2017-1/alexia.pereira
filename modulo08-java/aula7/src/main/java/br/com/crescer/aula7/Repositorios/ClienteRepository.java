package br.com.crescer.aula7.Repositorios;

import br.com.crescer.aula7.Entidades.Cliente;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author alexia.pereira
 */
public interface ClienteRepository  extends PagingAndSortingRepository <Cliente, Long> {
    
}
