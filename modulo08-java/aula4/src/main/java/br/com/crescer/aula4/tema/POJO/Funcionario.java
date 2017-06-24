package br.com.crescer.aula4.tema.POJO;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author alexia.pereira
 */
@Entity
public class Funcionario implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_FUNCIONARIO")
    private Long id;

    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;

    private String bairro;

    private String cidade;

    @Column(name = "NUMERO_CASA")
    private String numeroCasa;

    private String rua;

    @Basic(optional = false)
    @Column(name = "RG")
    private String rg;

    private String email;

    private String telefone;

    private String celular;

    private double salario;

    private String funcao;

    private String cpf;

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

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
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

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Funcionario() {

    }

    public Funcionario(Long id, String nome, String bairro, String cidade, String numeroCasa,
            String rua, String rg, String email, String telefone, String celular,
            double salario, String funcao, String cpf, Date dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.bairro = bairro;
        this.cidade = cidade;
        this.numeroCasa = numeroCasa;
        this.rua = rua;
        this.rg = rg;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
        this.salario = salario;
        this.funcao = funcao;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

}
