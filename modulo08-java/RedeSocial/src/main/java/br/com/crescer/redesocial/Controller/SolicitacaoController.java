package br.com.crescer.redesocial.Controller;

import br.com.crescer.redesocial.Entity.Solicitacao;
import br.com.crescer.redesocial.Entity.Usuario;
import br.com.crescer.redesocial.Service.SolicitacaoService;
import br.com.crescer.redesocial.Service.UsuarioService;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author A
 */
@RestController
@RequestMapping("/solicitacoes")
public class SolicitacaoController {

    @Autowired
    SolicitacaoService service;
    
    @Autowired
    UsuarioService usuarioService;

    @PostMapping
    public Solicitacao save(@RequestBody Solicitacao solicitacao) throws Exception {
        solicitacao.setIdSolicitacao(0l);
        return service.enviarSolicitacao(solicitacao);
    }

    @PostMapping(value = "/aceitar")
    public void accept(@RequestBody Solicitacao solicitacao) {
        service.aceitarSolicitacao(solicitacao);
    }
    
    @DeleteMapping(value="/delete/{idSolicitacao}")
    public void delete (@PathVariable Long idSolicitacao) {
        Solicitacao solicitacao = service.buscarPorId(idSolicitacao);
        service.remover(solicitacao);
    }

    @GetMapping(value = "/pendentes/{idUsuario}")
    public Set<Solicitacao> pendentes(@PathVariable Long idUsuario) {
        Usuario usuarioTarget = usuarioService.loadById(idUsuario);
        return service.buscarSolicitacoesPorUsuario(usuarioTarget);
    }

}
