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
@Table(name = "CURTIDAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Curtidas.findAll", query = "SELECT c FROM Curtidas c")
    , @NamedQuery(name = "Curtidas.findByIdCurtida", query = "SELECT c FROM Curtidas c WHERE c.idCurtida = :idCurtida")})
public class Curtidas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CURTIDA")
    private Long idCurtida;
    @JoinColumn(name = "ID_POST", referencedColumnName = "ID_POST")
    @ManyToOne
    private Post idPost;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario idUsuario;

    public Curtidas() {
    }

    public Curtidas(Long idCurtida) {
        this.idCurtida = idCurtida;
    }

    public Long getIdCurtida() {
        return idCurtida;
    }

    public void setIdCurtida(Long idCurtida) {
        this.idCurtida = idCurtida;
    }

    public Post getIdPost() {
        return idPost;
    }

    public void setIdPost(Post idPost) {
        this.idPost = idPost;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCurtida != null ? idCurtida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curtidas)) {
            return false;
        }
        Curtidas other = (Curtidas) object;
        if ((this.idCurtida == null && other.idCurtida != null) || (this.idCurtida != null && !this.idCurtida.equals(other.idCurtida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crescer.redesocial.Curtidas[ idCurtida=" + idCurtida + " ]";
    }
    
}
