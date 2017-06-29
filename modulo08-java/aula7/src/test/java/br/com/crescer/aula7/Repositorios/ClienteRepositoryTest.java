package br.com.crescer.aula7.Repositorios;

import br.com.crescer.aula7.Entidades.Cliente;
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
public class ClienteRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private ClienteRepository repositorio;

    /**
     * Test of save method, of class GeneroService.
     */
    @Test
    public void testSave() {
        final Cliente cliente = instanciarCliente();
        repositorio.save(cliente);
        assertEquals(cliente.getNome(), testEntityManager.find(Cliente.class, cliente.getId()).getNome());
    }

    /**
     * Test of findAll method, of class GeneroService.
     */
    @Test
    public void testFindAll() {
        final Cliente cliente = instanciarCliente();
        testEntityManager.persist(cliente);

        assertTrue(StreamSupport.stream(repositorio.findAll().spliterator(), false)
                .map(Cliente::getNome)
                .collect(toList())
                .contains(cliente.getNome()));

    }

    /**
     * Test of findOne method, of class GeneroService.
     */
    @Test
    public void testFindOne() {
        final Cliente cliente = instanciarCliente();
        testEntityManager.persist(cliente);
        assertEquals(cliente.getNome(), repositorio.findOne(cliente.getId()).getNome());
    }

    @Test
    public void testRemove() {
        final Cliente cliente = instanciarCliente();
        testEntityManager.persist(cliente);
        repositorio.delete(cliente);
        assertNull(repositorio.findOne(cliente.getId()));
    }

    @Test
    public void testUpdate() {
        final Cliente cliente = instanciarCliente();
        String nomeAntiga = "Nome";
        cliente.setNome("nomeAntiga");
        testEntityManager.persist(cliente);
        String nomeNova = "Testando 2";
        cliente.setNome(nomeNova);
        testEntityManager.persist(cliente);
        assertNotEquals(nomeAntiga, repositorio.findOne(cliente.getId()).getNome());
        assertEquals(nomeNova, repositorio.findOne(cliente.getId()).getNome());
    }

    private Cliente instanciarCliente() {
        return new Cliente("Teste", "00000000000", "1234567",
                "Teste", "Teste", "Teste", "123", "teste@email.com",
                "70707070", "5598237284", new Date());
    }

}
