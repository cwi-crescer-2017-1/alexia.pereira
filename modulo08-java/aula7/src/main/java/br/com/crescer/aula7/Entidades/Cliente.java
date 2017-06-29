package br.com.crescer.aula7.Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author A
 */
@Entity
public class Cliente implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CLIENTE")
    @SequenceGenerator(
            name = "SEQ_CLIENTE",
            sequenceName = "SEQ_CLIENTE",
            allocationSize = 1
    )

    private Long id;

    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;

    @Basic(optional = false)
    private String cpf;

    @Column(name = "RG")
    private String rg;

    private String rua;

    private String bairro;

    private String cidade;

    @Column(name = "NUMERO_CASA")
    private String numeroCasa;

    private String email;

    private String telefone;

    @Basic(optional = false)
    private String celular;

    @Column(name = "NASCIMENTO")
    private Date dataNascimento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(String numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Cliente(Long id, String nome, String cpf, String rg, String rua, String bairro, String cidade, String numeroCasa, String email, String telefone, String celular, Date dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.numeroCasa = numeroCasa;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
        this.dataNascimento = dataNascimento;
    }

    public Cliente(String nome, String cpf, String rg, String rua, String bairro, String cidade, String numeroCasa, String email, String telefone, String celular, Date dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.numeroCasa = numeroCasa;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
        this.dataNascimento = dataNascimento;
    }

    public Cliente() {
    }
}
