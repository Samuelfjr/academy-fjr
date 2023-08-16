package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "medidas")
public class Medidas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idAluno;
    private int idMedidas; //colocar na consulta
    private float altura, peso, bracoDir, bracoEsq, peitoral, quadril, coxaDir, coxaEsq, panturrilhaDir, panturrilhaEsq;
    private Date dataCadastro;

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public int getIdMedidas() {
        return idMedidas;
    }

    public void setIdMedidas(int idMedidas) {
        this.idMedidas = idMedidas;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getBracoDir() {
        return bracoDir;
    }

    public void setBracoDir(float bracoDir) {
        this.bracoDir = bracoDir;
    }

    public float getBracoEsq() {
        return bracoEsq;
    }

    public void setBracoEsq(float bracoEsq) {
        this.bracoEsq = bracoEsq;
    }

    public float getPeitoral() {
        return peitoral;
    }

    public void setPeitoral(float peitoral) {
        this.peitoral = peitoral;
    }

    public float getQuadril() {
        return quadril;
    }

    public void setQuadril(float quadril) {
        this.quadril = quadril;
    }

    public float getCoxaDir() {
        return coxaDir;
    }

    public void setCoxaDir(float coxaDir) {
        this.coxaDir = coxaDir;
    }

    public float getCoxaEsq() {
        return coxaEsq;
    }

    public void setCoxaEsq(float coxaEsq) {
        this.coxaEsq = coxaEsq;
    }

    public float getPanturrilhaDir() {
        return panturrilhaDir;
    }

    public void setPanturrilhaDir(float panturrilhaDir) {
        this.panturrilhaDir = panturrilhaDir;
    }

    public float getPanturrilhaEsq() {
        return panturrilhaEsq;
    }

    public void setPanturrilhaEsq(float panturrilhaEsq) {
        this.panturrilhaEsq = panturrilhaEsq;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }
    public Date setDataCadastro(Date dataCadastro) {
        return this.dataCadastro = dataCadastro;
    }
}
