package br.com.crescer.aula7.Repositorios;

import br.com.crescer.aula7.Entidades.Video;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author alexia.pereira
 */
public interface VideoRepository extends PagingAndSortingRepository<Video, Long> {

}
