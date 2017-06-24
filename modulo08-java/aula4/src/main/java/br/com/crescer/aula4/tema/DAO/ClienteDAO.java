package br.com.crescer.aula4.tema.DAO;

import br.com.crescer.aula4.tema.POJO.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author alexia.pereira
 */
public class ClienteDAO extends AbstractDAO<Cliente, Long> {

    public ClienteDAO(EntityManager em, EntityManagerFactory emf) {
        super(Cliente.class, em, emf);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return super.save(cliente);
    }

    @Override
    public void remove(Cliente cliente) {
        super.remove(cliente);
    }

    @Override
    public Cliente loadById(Long id) {
        return super.loadById(id);
    }

    @Override
    public List<Cliente> findAll() {
        return super.findAll();
    }

}
