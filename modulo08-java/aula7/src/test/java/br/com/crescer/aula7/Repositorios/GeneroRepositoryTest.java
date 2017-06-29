package br.com.crescer.aula7.Repositorios;

import br.com.crescer.aula7.Entidades.Genero;
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
import org.springframework.test.context.ActiveProfiles;
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
@ActiveProfiles("test")
public class GeneroRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private GeneroRepository repositorio;

    /**
     * Test of save method, of class GeneroService.
     */
    @Test
    public void testSave() {
        final Genero genero = new Genero();
        genero.setDescricao("Teste");
        repositorio.save(genero);
        assertEquals(genero.getDescricao(), testEntityManager.find(Genero.class, genero.getId()).getDescricao());
    }

    /**
     * Test of findAll method, of class GeneroService.
     */
    @Test
    public void testFindAll() {
        final Genero genero = new Genero();
        genero.setDescricao("Teste");
        testEntityManager.persist(genero);

        assertTrue(StreamSupport.stream(repositorio.findAll().spliterator(), false)
                .map(Genero::getDescricao)
                .collect(toList())
                .contains(genero.getDescricao()));

    }

    /**
     * Test of findOne method, of class GeneroService.
     */
    @Test
    public void testFindOne() {
        final Genero genero = new Genero();
        genero.setDescricao("Teste");
        testEntityManager.persist(genero);
        assertEquals(genero.getDescricao(), repositorio.findOne(genero.getId()).getDescricao());
    }

    @Test
    public void testRemove() {
        final Genero genero = new Genero();
        genero.setDescricao("Teste");
        testEntityManager.persist(genero);
        repositorio.delete(genero);
        assertNull(repositorio.findOne(genero.getId()));
    }

    @Test
    public void testUpdate() {
        final Genero genero = new Genero();
        String descricaoAntiga = "Descricao";
        genero.setDescricao("descricaoAntiga");
        testEntityManager.persist(genero);
        String descricaoNova = "Testando 2";
        genero.setDescricao(descricaoNova);
        testEntityManager.persist(genero);
        assertNotEquals(descricaoAntiga, repositorio.findOne(genero.getId()).getDescricao());
        assertEquals(descricaoNova, repositorio.findOne(genero.getId()).getDescricao());
    }

}
