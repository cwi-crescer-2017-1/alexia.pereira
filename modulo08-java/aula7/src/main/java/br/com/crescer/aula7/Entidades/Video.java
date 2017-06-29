package br.com.crescer.aula7.Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author alexia.pereira
 */
@Entity
public class Video implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_VIDEO")
    @SequenceGenerator(
            name = "SEQ_VIDEO",
            sequenceName = "SEQ_VIDEO",
            allocationSize = 1
    )
    private Long id;

    @Basic(optional = false)
    private double valor;

    private String duracao;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ID_GENERO")
    private Genero genero;

    private String nome;

    @Column(name = "QUANTIDADE_ESTOQUE")
    private int quantidadeEstoque;

    @Column(name = "DATA_LANCAMENTO")
    private Date dataLancamento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Video() {
    }

    public Video(Long id, double valor, String duracao, Genero genero, String nome, int quantidadeEstoque, Date dataLancamento) {
        this.id = id;
        this.valor = valor;
        this.duracao = duracao;
        this.genero = genero;
        this.nome = nome;
        this.quantidadeEstoque = quantidadeEstoque;
        this.dataLancamento = dataLancamento;
    }

    public Video(double valor, String duracao, Genero genero, String nome, int quantidadeEstoque, Date dataLancamento) {
        this.valor = valor;
        this.duracao = duracao;
        this.genero = genero;
        this.nome = nome;
        this.quantidadeEstoque = quantidadeEstoque;
        this.dataLancamento = dataLancamento;
    }

}
