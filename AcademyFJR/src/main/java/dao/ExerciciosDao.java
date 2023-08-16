package dao;

import model.Exercicios;

import javax.persistence.EntityManager;
import java.util.List;

public class ExerciciosDao {

    private EntityManager em;

    public ExerciciosDao(EntityManager em) {this.em = em;}

    public void cadastrar(Exercicios exerciciosDao) { this.em.persist(exerciciosDao);}

    public List<Exercicios> buscarTodos() {
        String jpql = "SELECT e FROM Exercicios e";
        return em.createQuery(jpql, Exercicios.class).getResultList();
    }

    public void removerExercicio(Exercicios exerciciosDao) {
        em.merge(exerciciosDao);
        em.remove(exerciciosDao);
    }

    public void alterar(Exercicios exerciciosDao) {
        em.merge(exerciciosDao);
    }

    public Exercicios buscarPorId(int id) {
        return em.find(Exercicios.class, id);
    }
}