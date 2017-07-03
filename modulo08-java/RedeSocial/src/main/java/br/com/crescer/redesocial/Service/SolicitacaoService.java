package br.com.crescer.redesocial.Service;

import br.com.crescer.redesocial.Entity.Amizade;
import br.com.crescer.redesocial.Entity.Solicitacao;
import br.com.crescer.redesocial.Entity.Usuario;
import br.com.crescer.redesocial.Exceptions.AdicionarASiMesmo;
import br.com.crescer.redesocial.Exceptions.JaSaoAmigos;
import br.com.crescer.redesocial.Repository.SolicitacaoRepository;
import java.util.Set;
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

    @Autowired
    UsuarioService usuarioService;

    public Solicitacao enviarSolicitacao(Solicitacao solicitacao) throws Exception {
        solicitacao.setIdSolicitacao(0l);
        this.solicitacaoEhValida(solicitacao);
        return repository.save(solicitacao);
    }

    public void aceitarSolicitacao(Solicitacao solicitacao) {
        Amizade amizade = new Amizade(solicitacao.getUsuarioOwner(), solicitacao.getUsuarioTarget());
        amizade.setIdAmizade(0l);
        amizadeService.save(amizade);
        repository.delete(solicitacao);
    }

    public Set<Solicitacao> buscarSolicitacoesPorUsuario(Usuario usuarioTarget) {
        return repository.findByUsuarioTarget(usuarioTarget);
    }

    public void remover(Solicitacao solicitacao) {
        repository.delete(solicitacao);
    }

    public Solicitacao buscarPorId(Long idSolicitacao) {
        return repository.findOne(idSolicitacao);
    }

    private void solicitacaoEhValida(Solicitacao solicitacao) throws AdicionarASiMesmo, JaSaoAmigos {
        usuarioService.buscarAmigos(solicitacao.getUsuarioOwner());
        if (solicitacao.getUsuarioOwner().getIdUsuario() == solicitacao.getUsuarioTarget().getIdUsuario()) {
            throw new AdicionarASiMesmo();
        }
        if (solicitacao.getUsuarioOwner().getAmigos().contains(solicitacao.getUsuarioTarget())) {
            throw new JaSaoAmigos();
        }

    }

}
