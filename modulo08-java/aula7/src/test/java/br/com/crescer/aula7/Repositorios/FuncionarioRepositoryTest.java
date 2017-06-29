package br.com.crescer.aula7.Repositorios;

import br.com.crescer.aula7.Entidades.Funcionario;
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
public class FuncionarioRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private FuncionarioRepository repositorio;

    /**
     * Test of save method, of class GeneroService.
     */
    @Test
    public void testSave() {
        final Funcionario funcionario = instanciarFuncionario();
        repositorio.save(funcionario);
        assertEquals(funcionario.getNome(), testEntityManager.find(Funcionario.class, funcionario.getId()).getNome());
    }

    /**
     * Test of findAll method, of class GeneroService.
     */
    @Test
    public void testFindAll() {
        final Funcionario funcionario = instanciarFuncionario();
        testEntityManager.persist(funcionario);

        assertTrue(StreamSupport.stream(repositorio.findAll().spliterator(), false)
                .map(Funcionario::getNome)
                .collect(toList())
                .contains(funcionario.getNome()));

    }

    /**
     * Test of findOne method, of class GeneroService.
     */
    @Test
    public void testFindOne() {
        final Funcionario funcionario = instanciarFuncionario();
        testEntityManager.persist(funcionario);
        assertEquals(funcionario.getNome(), repositorio.findOne(funcionario.getId()).getNome());
    }

    @Test
    public void testRemove() {
        final Funcionario funcionario = instanciarFuncionario();
        testEntityManager.persist(funcionario);
        repositorio.delete(funcionario);
        assertNull(repositorio.findOne(funcionario.getId()));
    }

    @Test
    public void testUpdate() {
        final Funcionario funcionario = instanciarFuncionario();
        String nomeAntiga = "Nome";
        funcionario.setNome("nomeAntiga");
        testEntityManager.persist(funcionario);
        String nomeNova = "Testando 2";
        funcionario.setNome(nomeNova);
        testEntityManager.persist(funcionario);
        assertNotEquals(nomeAntiga, repositorio.findOne(funcionario.getId()).getNome());
        assertEquals(nomeNova, repositorio.findOne(funcionario.getId()).getNome());
    }

    private Funcionario instanciarFuncionario() {
        return new Funcionario("Funcionario teste", "Teste", "Teste",
                "123", "Teste", "Teste", "teste@email", "3279274", "5513123818",
                500d, "Crescer", "707070707070", new Date());
    }

}
