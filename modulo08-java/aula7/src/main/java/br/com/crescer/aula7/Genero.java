package br.com.crescer.aula7;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author alexia.pereira
 */
@Entity
public class Genero implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERO")
    @SequenceGenerator(
            name = "SEQ_GENERO",
            sequenceName = "SEQ_GENERO",
            allocationSize = 1
    )

    private Long id;

    @Basic(optional = false)
    @Column(name = "DESCRICAO")
    private String descricao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Genero(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Genero() {
    }

    public Genero(String descricao) {
        this.descricao = descricao;
    }

}
