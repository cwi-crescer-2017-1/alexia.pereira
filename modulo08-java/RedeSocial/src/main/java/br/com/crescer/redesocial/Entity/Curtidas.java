package br.com.crescer.redesocial.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CURTIDAS")
    @SequenceGenerator(
            name = "SEQ_CURTIDAS",
            sequenceName = "SEQ_CURTIDAS",
            allocationSize = 1
    )
    private Long idCurtida;

    @JoinColumn(name = "ID_POST", referencedColumnName = "ID_POST")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    private Post post;

    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario usuario;

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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
