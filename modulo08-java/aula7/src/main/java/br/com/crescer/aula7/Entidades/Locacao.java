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
public class Locacao implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_LOCACAO")
    @SequenceGenerator(
            name = "SEQ_LOCACAO",
            sequenceName = "SEQ_LOCACAO",
            allocationSize = 1
    )
    private Long id;

    @Column(name = "VALOR_TOTAL")
    private double valorTotal;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ID_FUNCIONARIO")
    private Funcionario funcionario;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ID_CLIENTE")
    private Cliente cliente;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ID_VIDEO")
    private Video video;

    @Column(name = "DATA_DEVOLUCAO")
    private Date dataDevolucao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Locacao() {
    }

    public Locacao(Long id, double valorTotal, Funcionario funcionario, Cliente cliente, Video video, Date dataDevolucao) {
        this.id = id;
        this.valorTotal = valorTotal;
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.video = video;
        this.dataDevolucao = dataDevolucao;
    }

    public Locacao(double valorTotal, Funcionario funcionario, Cliente cliente, Video video, Date dataDevolucao) {
        this.valorTotal = valorTotal;
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.video = video;
        this.dataDevolucao = dataDevolucao;
    }

}
