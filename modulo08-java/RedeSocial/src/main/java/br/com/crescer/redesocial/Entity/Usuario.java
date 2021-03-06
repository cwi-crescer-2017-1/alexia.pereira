package br.com.crescer.redesocial.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author alexia.pereira
 */
@Entity
@Table(name = "USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuario.findByNome", query = "SELECT u FROM Usuario u WHERE u.nome = :nome"),
    @NamedQuery(name = "Usuario.findBySexo", query = "SELECT u FROM Usuario u WHERE u.sexo = :sexo"),
    @NamedQuery(name = "Usuario.findByDataNascimento", query = "SELECT u FROM Usuario u WHERE u.dataNascimento = :dataNascimento"),
    @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email"),
    @NamedQuery(name = "Usuario.findBySenha", query = "SELECT u FROM Usuario u WHERE u.senha = :senha")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_USUARIO")
    private Long idUsuario;

    @Size(max = 100)
    @Column(name = "NOME")
    @NotNull
    private String nome;

    @Column(name = "SEXO")
    @NotNull
    private Character sexo;

    @Column(name = "DATA_NASCIMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date dataNascimento;

    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "EMAIL", unique = true)
    @NotNull
    private String email;

    @Size(max = 100)
    @Column(name = "SENHA")
    @NotNull
    private String senha;

    @Size(max = 50)
    @Column(name = "CASA")
    @NotNull
    private String casa;

    @Size(max = 500)
    @Column(name = "FOTO")
    @NotNull
    private String foto;

//    @OneToMany(mappedBy = "usuario")
//    private Set<Post> postSet;
    @OneToMany(mappedBy = "usuario1")
    @JsonProperty(access = Access.WRITE_ONLY)
    private Set<Amizade> amizadeSet;

    @Transient
    private Set<Usuario> amigos;

    @OneToMany(mappedBy = "usuarioTarget")
    @JsonProperty(access = Access.WRITE_ONLY)
    private Set<Solicitacao> solicitacaoSet;

//    @OneToMany(mappedBy = "idUsuario")
//    private Set<Curtidas> curtidasSet;

    public Usuario() {
        this.amigos = new HashSet<Usuario>();
    }

    public Usuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCasa() {
        return casa;
    }

    public void setCasa(String casa) {
        this.casa = casa;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @XmlTransient
    public Set<Amizade> getAmizadeSet() {
        return amizadeSet;
    }

    public void setAmizadeSet(Set<Amizade> amizadeSet) {
        this.amizadeSet = amizadeSet;
    }

    public Set<Usuario> getAmigos() {
        return amigos;
    }

    public void setAmigos(Set<Usuario> amigos) {
        this.amigos = amigos;
    }

    @XmlTransient
    public Set<Solicitacao> getSolicitacaoSet() {
        return solicitacaoSet;
    }

    public void setSolicitacaoSet(Set<Solicitacao> solicitacaoSet) {
        this.solicitacaoSet = solicitacaoSet;
    }

    public void criptografarSenha() {
        this.senha = new BCryptPasswordEncoder().encode(this.senha);
    }

}
