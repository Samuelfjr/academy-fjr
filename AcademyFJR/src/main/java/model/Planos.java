package model;

import javax.persistence.*;

@Entity
@Table(name = "planos")

public class Planos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPlanos;
    private int idExercicio;
    private String descricao;
    private double valor;

    public int getIdPlanos() {
        return idPlanos;
    }

    public void setIdPlanos(int idPlanos) {
        this.idPlanos = idPlanos;
    }

    public int getIdExercicio() {
        return idExercicio;
    }

    public void setIdExercicio(int idExercicio) {
        this.idExercicio = idExercicio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
