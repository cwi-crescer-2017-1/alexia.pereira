package br.com.crescer.redesocial.Controller;

import br.com.crescer.redesocial.Entity.Solicitacao;
import br.com.crescer.redesocial.Service.SolicitacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @PostMapping
    public Solicitacao save(@RequestBody Solicitacao solicitacao) {
        solicitacao.setIdSolicitacao(0l);
        return service.enviarSolicitacao(solicitacao);
    }
    
    
    @PostMapping(value="/aceitar")
    public void accept(@RequestBody Solicitacao solicitacao) {
        service.aceitarSolicitacao(solicitacao);
    }
    
}
