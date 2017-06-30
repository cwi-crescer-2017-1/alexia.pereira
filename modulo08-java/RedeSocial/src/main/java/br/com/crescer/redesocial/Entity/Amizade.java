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
@Table(name = "AMIZADE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Amizade.findAll", query = "SELECT a FROM Amizade a")
    , @NamedQuery(name = "Amizade.findByIdAmizade", query = "SELECT a FROM Amizade a WHERE a.idAmizade = :idAmizade")})
public class Amizade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_AMIZADE")
    private Long idAmizade;
    @JoinColumn(name = "ID_USUARIO_1", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario idUsuario1;
    @JoinColumn(name = "ID_USUARIO_2", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario idUsuario2;

    public Amizade() {
    }

    public Amizade(Long idAmizade) {
        this.idAmizade = idAmizade;
    }

    public Long getIdAmizade() {
        return idAmizade;
    }

    public void setIdAmizade(Long idAmizade) {
        this.idAmizade = idAmizade;
    }

    public Usuario getIdUsuario1() {
        return idUsuario1;
    }

    public void setIdUsuario1(Usuario idUsuario1) {
        this.idUsuario1 = idUsuario1;
    }

    public Usuario getIdUsuario2() {
        return idUsuario2;
    }

    public void setIdUsuario2(Usuario idUsuario2) {
        this.idUsuario2 = idUsuario2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAmizade != null ? idAmizade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Amizade)) {
            return false;
        }
        Amizade other = (Amizade) object;
        if ((this.idAmizade == null && other.idAmizade != null) || (this.idAmizade != null && !this.idAmizade.equals(other.idAmizade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crescer.redesocial.Amizade[ idAmizade=" + idAmizade + " ]";
    }
    
}
