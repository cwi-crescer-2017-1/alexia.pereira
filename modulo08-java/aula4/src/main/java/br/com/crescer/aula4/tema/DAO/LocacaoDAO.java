package br.com.crescer.aula4.tema.DAO;

import br.com.crescer.aula4.tema.POJO.Locacao;
import br.com.crescer.aula4.tema.POJO.Video;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author alexia.pereira
 */
public class LocacaoDAO extends AbstractDAO<Locacao, Long>{
    
    public LocacaoDAO(EntityManager entityManager, EntityManagerFactory entityManagerFactory) {
        super(Locacao.class, entityManager, entityManagerFactory);
    }
    
    @Override
    public Locacao save(Locacao locacao) {
        return super.save(locacao);
    }

    @Override
    public void remove(Locacao locacao) {
        super.remove(locacao);
    }

    @Override
    public Locacao loadById(Long id) {
        return super.loadById(id);
    }

    @Override
    public List<Locacao> findAll() {
        return super.findAll();
    }

    
}
