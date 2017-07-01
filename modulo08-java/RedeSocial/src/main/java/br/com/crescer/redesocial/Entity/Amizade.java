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
    @JoinColumn(name = "ID_USUARIO_1", referencedColumnName = "ID_USUARIO", unique = false)
    @ManyToOne
    private Usuario usuario1;
    @JoinColumn(name = "ID_USUARIO_2", referencedColumnName = "ID_USUARIO", unique = false)
    @ManyToOne
    private Usuario usuario2;

    public Amizade() {
    }

    public Amizade(Usuario usuario1, Usuario usuario2) {
        this.usuario1 = usuario1;
        this.usuario2 = usuario2;
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

    public Usuario getUsuario1() {
        return usuario1;
    }

    public void setUsuario1(Usuario usuario1) {
        this.usuario1 = usuario1;
    }

    public Usuario getUsuario2() {
        return usuario2;
    }

    public void setUsuario2(Usuario usuario2) {
        this.usuario2 = usuario2;
    }

}