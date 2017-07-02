package br.com.crescer.redesocial.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 *
 * @author alexia.pereira
 */
@Entity
@Table(name = "POST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Post.findAll", query = "SELECT p FROM Post p")
    , @NamedQuery(name = "Post.findByIdPost", query = "SELECT p FROM Post p WHERE p.idPost = :idPost")
    , @NamedQuery(name = "Post.findByDescricao", query = "SELECT p FROM Post p WHERE p.descricao = :descricao")
    , @NamedQuery(name = "Post.findByUrlImagem", query = "SELECT p FROM Post p WHERE p.urlImagem = :urlImagem")})
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_POST")
    private Long idPost;

    @Size(max = 500)
    @Column(name = "DESCRICAO")
    private String descricao;

    @Size(max = 200)
    @Column(name = "URL_IMAGEM")
    private String urlImagem;

    @Column(name = "DATA_PUBLICACAO")
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date dataPublicacao;

    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario usuario;

    @OneToMany(mappedBy = "idPost")
    private Set<Curtidas> curtidasSet;

    public Post() {
    }

    public Post(Long idPost) {
        this.idPost = idPost;
    }

    public Long getIdPost() {
        return idPost;
    }

    public void setIdPost(Long idPost) {
        this.idPost = idPost;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Date dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }
    
    

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @XmlTransient
    public Set<Curtidas> getCurtidasSet() {
        return curtidasSet;
    }

    public void setCurtidasSet(Set<Curtidas> curtidasSet) {
        this.curtidasSet = curtidasSet;
    }

}
