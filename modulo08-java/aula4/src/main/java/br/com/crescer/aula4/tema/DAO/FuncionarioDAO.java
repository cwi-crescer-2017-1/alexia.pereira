package br.com.crescer.aula4.tema.DAO;

import br.com.crescer.aula4.tema.POJO.Funcionario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author alexia.pereira
 */
public class FuncionarioDAO extends AbstractDAO<Funcionario, Long> {

    public FuncionarioDAO(EntityManager em, EntityManagerFactory emf) {
        super(Funcionario.class, em, emf);
    }

    @Override
    public Funcionario save(Funcionario funcionario) {
        return super.save(funcionario);
    }

    @Override
    public void remove(Funcionario funcionario) {
        super.remove(funcionario);
    }

    @Override
    public Funcionario loadById(Long id) {
        return super.loadById(id);
    }

    @Override
    public List<Funcionario> findAll() {
        return super.findAll();
    }

}
