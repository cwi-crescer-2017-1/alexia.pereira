package br.com.crescer.redesocial.Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alexia.pereira
 */
@Entity
@Table(name = "SOLICITACAO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solicitacao.findAll", query = "SELECT s FROM Solicitacao s")
    , @NamedQuery(name = "Solicitacao.findByIdSolicitacao", query = "SELECT s FROM Solicitacao s WHERE s.idSolicitacao = :idSolicitacao")})
public class Solicitacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SOLICITACAO")
    private Long idSolicitacao;
    @JoinColumn(name = "ID_USUARIO_OWNER", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario usuarioOwner;
    @JoinColumn(name = "ID_USUARIO_TARGET", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario usuarioTarget;

    public Solicitacao() {
    }

    public Solicitacao(Usuario usuarioOwner, Usuario usuarioTarget) {
        this.usuarioOwner = usuarioOwner;
        this.usuarioTarget = usuarioTarget;
    }

    public Solicitacao(Long idSolicitacao) {
        this.idSolicitacao = idSolicitacao;
    }

    public Long getIdSolicitacao() {
        return idSolicitacao;
    }

    public void setIdSolicitacao(Long idSolicitacao) {
        this.idSolicitacao = idSolicitacao;
    }

    public Usuario getUsuarioOwner() {
        return usuarioOwner;
    }

    public void setUsuarioOwner(Usuario usuarioOwner) {
        this.usuarioOwner = usuarioOwner;
    }

    public Usuario getUsuarioTarget() {
        return usuarioTarget;
    }

    public void setUsuarioTarget(Usuario usuarioTarget) {
        this.usuarioTarget = usuarioTarget;
    }

}
