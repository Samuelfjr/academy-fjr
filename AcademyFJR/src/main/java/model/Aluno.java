package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idAluno;
    private int cpf, senha;
    private long telefone;
    private String nomeCompleto, endereco, email;
    private Date dataNascimento;
    private Date dataMatricula;

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = this.cpf;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
    public Date getDataNascimento() {
        return dataNascimento;
    }

    public Date setDataNascimento(Date dataNascimento) {
        return this.dataNascimento = dataNascimento;
    }

    public Date getDataMatricula() {
        return dataMatricula;
    }

    public Date setDataMatricula(Date dataMatricula) {
        return this.dataMatricula = dataMatricula;
    }
}
