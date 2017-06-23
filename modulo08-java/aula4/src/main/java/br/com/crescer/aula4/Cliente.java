package br.com.crescer.aula4;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author alexia.pereira
 */
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "ID_CLIENTE")
    private Long ID;
    
    @Column(name = "NM_CLIENTE")
    private String nome;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
