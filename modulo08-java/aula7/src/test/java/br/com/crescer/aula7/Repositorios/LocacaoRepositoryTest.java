package br.com.crescer.aula7.Repositorios;

import br.com.crescer.aula7.Entidades.Cliente;
import br.com.crescer.aula7.Entidades.Funcionario;
import br.com.crescer.aula7.Entidades.Genero;
import br.com.crescer.aula7.Entidades.Locacao;
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
public class LocacaoRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private LocacaoRepository repositorio;

    /**
     * Test of save method, of class GeneroService.
     */
    @Test
    public void testSave() {
        final Locacao locacao = instanciarLocacao();
        repositorio.save(locacao);
        assertEquals(locacao.getValorTotal(), testEntityManager.find(Locacao.class, locacao.getId()).getValorTotal(), 0.1);
    }

    /**
     * Test of findAll method, of class GeneroService.
     */
    @Test
    public void testFindAll() {
        final Locacao locacao = instanciarLocacao();
        testEntityManager.persist(locacao);

        assertTrue(StreamSupport.stream(repositorio.findAll().spliterator(), false)
                .map(Locacao::getValorTotal)
                .collect(toList())
                .contains(locacao.getValorTotal()));

    }

    /**
     * Test of findOne method, of class GeneroService.
     */
    @Test
    public void testFindOne() {
        final Locacao locacao = instanciarLocacao();
        testEntityManager.persist(locacao);
        assertEquals(locacao.getValorTotal(), repositorio.findOne(locacao.getId()).getValorTotal(), 0.1);
    }

    @Test
    public void testRemove() {
        final Locacao locacao = instanciarLocacao();
        testEntityManager.persist(locacao);
        repositorio.delete(locacao);
        assertNull(repositorio.findOne(locacao.getId()));
    }

    @Test
    public void testUpdate() {
        final Locacao locacao = instanciarLocacao();
        testEntityManager.persist(locacao);
        locacao.setValorTotal(20);
        testEntityManager.persist(locacao);
        assertNotEquals(10, repositorio.findOne(locacao.getId()).getValorTotal());
        assertEquals(20, repositorio.findOne(locacao.getId()).getValorTotal(), 0.1);
    }

    private Locacao instanciarLocacao() {
        Funcionario funcionario = new Funcionario("Funcionario teste", "Teste", "Teste",
                "123", "Teste", "Teste", "teste@email", "3279274", "5513123818",
                500d, "Crescer", "707070707070", new Date());
        Cliente cliente = new Cliente("Teste", "00000000000", "1234567",
                "Teste", "Teste", "Teste", "123", "teste@email.com",
                "70707070", "5598237284", new Date());
        Genero genero = new Genero("Aventura");
        Video video = new Video(5, "2 horas", genero, "BVS", 3, new Date());

        return new Locacao(10, funcionario, cliente, video, new Date());
    }

}
