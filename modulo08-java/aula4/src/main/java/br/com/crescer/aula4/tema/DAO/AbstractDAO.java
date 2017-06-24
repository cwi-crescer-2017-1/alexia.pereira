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
public abstract class AbstractDAO<Entity, ID> implements CrudDao<Entity, ID> {

    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;
    final Session session;
    private Class classePersistida;

    public Class<Entity> clazz;

    protected AbstractDAO(Class<Entity> clazz, EntityManager entityManager, EntityManagerFactory entityManagerFactory) {
        this.classePersistida = clazz;
        this.entityManager = entityManager;
        this.entityManagerFactory = entityManagerFactory;
        this.session = entityManager.unwrap(Session.class);
    }
    
    @Override
    public Entity save(Entity e) {
        entityManager.getTransaction().begin();
        entityManager.persist(e);
        entityManager.getTransaction().commit();
        return e;
    }

    @Override
    public void remove(Entity e) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.contains(e) ? e : entityManager.merge(e));
        entityManager.getTransaction().commit();
    }

    @Override
    public Entity loadById(ID id) {
        return (Entity) entityManager.find(this.classePersistida, id);
    }

    @Override
    public List findAll() {
        return session.createCriteria(this.classePersistida).list();
    }

}
