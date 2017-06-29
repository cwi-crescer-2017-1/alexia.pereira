package br.com.crescer.aula7.Repositorios;

import br.com.crescer.aula7.Entidades.Genero;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author alexia.pereira
 */
public interface GeneroRepository extends PagingAndSortingRepository <Genero, Long> {
    
}
