package br.com.crescer.aula4;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author alexia.pereira
 */
public class Run {

    public static void main(String[] args) {
        // Criando um EntityManager
        final EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager em;
        em = emf.createEntityManager();

        Cliente cliente = new Cliente();
//        Cliente cliente = em.find(Cliente.class, 1l);
        em.getTransaction().begin();
//        em.remove(cliente);
        cliente.setID(1l);
        cliente.setNome("Aléxia Pereira");
        em.persist(cliente);
        em.getTransaction().commit();

        em.close();
        emf.close();

    }
}
