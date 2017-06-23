package br.com.crescer.aula4;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;

/**
 *
 * @author alexia.pereira
 */
public class RunHibernate {

    public static void main(String[] args) {
        // Criando um EntityManager
        final EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager em;
        em = emf.createEntityManager();
        
        em.getTransaction().begin();
        final Session session = em.unwrap(Session.class);
        Cliente cliente = (Cliente)session.load(Cliente.class, 1l);
        cliente.setNome("Aléxia");
        session.saveOrUpdate(cliente);
        em.getTransaction().commit();

        em.close();
        emf.close();

    }
}
