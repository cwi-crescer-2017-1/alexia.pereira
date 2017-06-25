package br.com.crescer.aula4.tema.DAO;

import br.com.crescer.aula4.tema.POJO.Video;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author alexia.pereira
 */
public class VideoDAO extends AbstractDAO<Video, Long> {

    public VideoDAO(EntityManager entityManager, EntityManagerFactory entityManagerFactory) {
        super(Video.class, entityManager, entityManagerFactory);
    }

    @Override
    public Video save(Video video) {
        return super.save(video);
    }

    @Override
    public void remove(Video video) {
        super.remove(video);
    }

    @Override
    public Video loadById(Long id) {
        return super.loadById(id);
    }

    @Override
    public List<Video> findAll() {
        return super.findAll();
    }

}
