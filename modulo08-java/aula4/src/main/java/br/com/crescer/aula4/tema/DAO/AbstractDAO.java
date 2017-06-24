package br.com.crescer.aula4.tema.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;

/**
 *
 * @author alexia.pereira
 * @param <T>
 */
public abstract class AbstractDAO<T, ID> implements CrudDao<T, ID> {

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CRESCER");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();
    final Session session = entityManager.unwrap(Session.class);
    private Class classePersistida;

    public Class<T> clazz;

    protected AbstractDAO(Class<T> clazz) {
        this.classePersistida = clazz;
    }

    @Override
    public Object save(Object e) {
        entityManager.getTransaction().begin();
        entityManager.persist(e);
        entityManager.getTransaction().commit();
        return e;
    }

    @Override
    public void remove(Object e) {
        entityManager.getTransaction().begin();
        entityManager.remove(e);
        entityManager.getTransaction().commit();
    }

    @Override
    public T loadById(ID id) {
        return (T) entityManager.find(this.classePersistida, id);
    }

    @Override
    public List findAll() {
        return session.createCriteria(this.classePersistida).list();
    }

}
