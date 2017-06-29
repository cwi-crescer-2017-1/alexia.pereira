package br.com.crescer.aula7.Repositorios;

import br.com.crescer.aula7.Entidades.Genero;
import br.com.crescer.aula7.Entidades.Video;
import java.util.Date;
import static java.util.stream.Collectors.toList;
import java.util.stream.StreamSupport;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author alexia.pereira
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional(propagation = Propagation.REQUIRED)
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class VideoRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private VideoRepository repositorio;

    /**
     * Test of save method, of class GeneroService.
     */
    @Test
    public void testSave() {
        final Video video = instanciarVideo();
        repositorio.save(video);
        assertEquals(video.getNome(), testEntityManager.find(Video.class, video.getId()).getNome());
    }

    /**
     * Test of findAll method, of class GeneroService.
     */
    @Test
    public void testFindAll() {
        final Video video = instanciarVideo();
        testEntityManager.persist(video);

        assertTrue(StreamSupport.stream(repositorio.findAll().spliterator(), false)
                .map(Video::getNome)
                .collect(toList())
                .contains(video.getNome()));

    }

    /**
     * Test of findOne method, of class GeneroService.
     */
    @Test
    public void testFindOne() {
        final Video video = instanciarVideo();
        testEntityManager.persist(video);
        assertEquals(video.getNome(), repositorio.findOne(video.getId()).getNome());
    }

    @Test
    public void testRemove() {
        final Video video = instanciarVideo();
        testEntityManager.persist(video);
        repositorio.delete(video);
        assertNull(repositorio.findOne(video.getId()));
    }

    @Test
    public void testUpdate() {
        final Video video = instanciarVideo();
        String nomeAntigo = video.getNome();
        testEntityManager.persist(video);
        String novoNome = "Novo nome";
        video.setNome(novoNome);
        testEntityManager.persist(video);
        assertNotEquals(nomeAntigo, repositorio.findOne(video.getId()).getNome());
        assertEquals(novoNome, repositorio.findOne(video.getId()).getNome());
    }

    private Video instanciarVideo() {
        Genero genero = new Genero("Aventura");
        return new Video(5, "2 horas", genero, "BVS", 3, new Date());

    }

}
