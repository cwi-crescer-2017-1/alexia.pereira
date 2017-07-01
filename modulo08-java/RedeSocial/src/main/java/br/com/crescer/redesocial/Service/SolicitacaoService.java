package br.com.crescer.redesocial.Service;

import br.com.crescer.redesocial.Entity.Amizade;
import br.com.crescer.redesocial.Entity.Solicitacao;
import br.com.crescer.redesocial.Repository.SolicitacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author A
 */
@Service
public class SolicitacaoService {

    @Autowired
    SolicitacaoRepository repository;

    @Autowired
    AmizadeService amizadeService;

    public Solicitacao enviarSolicitacao(Solicitacao solicitacao) {
        solicitacao.setIdSolicitacao(0l);
        return repository.save(solicitacao);
    }

    public void aceitarSolicitacao(Solicitacao solicitacao) {
        Amizade amizade = new Amizade(solicitacao.getUsuarioOwner(), solicitacao.getUsuarioTarget());
        amizade.setIdAmizade(0l);
        amizadeService.save(amizade);
        repository.delete(solicitacao);
    }

}
