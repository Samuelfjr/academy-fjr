package model;

import javax.persistence.*;

@Entity
@Table(name = "exercicios")

public class Exercicios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idExercicio;
    private String nomeExercicio;

    public int getIdExercicio() {
        return idExercicio;
    }

    public void setIdExercicio(int idExercicio) {
        this.idExercicio = idExercicio;
    }

    public String getNomeExercicio() {
        return nomeExercicio;
    }

    public void setNomeExercicio(String nomeExercicio) {
        this.nomeExercicio = nomeExercicio;
    }
}
