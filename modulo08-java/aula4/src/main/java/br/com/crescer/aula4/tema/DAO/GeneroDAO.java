package br.com.crescer.aula4.tema.DAO;

import br.com.crescer.aula4.tema.POJO.Genero;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author alexia.pereira
 */
public class GeneroDAO extends AbstractDAO<Genero, Long> {

    public GeneroDAO(EntityManager entityManager, EntityManagerFactory entityManagerFactory) {
        super(Genero.class, entityManager, entityManagerFactory);
    }

    @Override
    public Genero save(Genero genero) {
        return super.save(genero);
    }

    @Override
    public void remove(Genero genero) {
        super.remove(genero);
    }

    @Override
    public Genero loadById(Long id) {
        return super.loadById(id);
    }

    @Override
    public List<Genero> findAll() {
        return super.findAll();
    }

}
