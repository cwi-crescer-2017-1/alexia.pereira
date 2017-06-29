package br.com.crescer.aula7.Services;

import br.com.crescer.aula7.Entidades.Locacao;
import br.com.crescer.aula7.Repositorios.LocacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alexia.pereira
 */
@Service
public class LocacaoService {

    @Autowired
    LocacaoRepository repositorio;

    public Iterable<Locacao> findAll() {
        return repositorio.findAll();
    }

    public Locacao save(Locacao locacao) {
        return repositorio.save(locacao);
    }

    public Locacao update(Locacao locacao) {
        return repositorio.save(locacao);
    }

    public void remove(Locacao locacao) {
        repositorio.delete(locacao);
    }

    public Locacao loadById(Long id) {
        return repositorio.findOne(id);
    }

}
