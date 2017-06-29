package br.com.crescer.aula7.Services;

import br.com.crescer.aula7.Entidades.Video;
import br.com.crescer.aula7.Repositorios.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alexia.pereira
 */
@Service
public class VideoService {

    @Autowired
    VideoRepository repositorio;

    public Iterable<Video> findAll() {
        return repositorio.findAll();
    }

    public Video save(Video video) {
        return repositorio.save(video);
    }

    public Video update(Video video) {
        return repositorio.save(video);
    }

    public void remove(Video video) {
        repositorio.delete(video);
    }

    public Video loadById(Long id) {
        return repositorio.findOne(id);
    }

}
