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
    private Usuario idUsuarioOwner;
    @JoinColumn(name = "ID_USUARIO_TARGET", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario idUsuarioTarget;

    public Solicitacao() {
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

    public Usuario getIdUsuarioOwner() {
        return idUsuarioOwner;
    }

    public void setIdUsuarioOwner(Usuario idUsuarioOwner) {
        this.idUsuarioOwner = idUsuarioOwner;
    }

    public Usuario getIdUsuarioTarget() {
        return idUsuarioTarget;
    }

    public void setIdUsuarioTarget(Usuario idUsuarioTarget) {
        this.idUsuarioTarget = idUsuarioTarget;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSolicitacao != null ? idSolicitacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitacao)) {
            return false;
        }
        Solicitacao other = (Solicitacao) object;
        if ((this.idSolicitacao == null && other.idSolicitacao != null) || (this.idSolicitacao != null && !this.idSolicitacao.equals(other.idSolicitacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crescer.redesocial.Solicitacao[ idSolicitacao=" + idSolicitacao + " ]";
    }
    
}
