package dao;

import model.Matricula;

import javax.persistence.EntityManager;
import java.util.List;

public class MatriculaDao {
    private static EntityManager em;

    public MatriculaDao(EntityManager em) {this.em = em;}

    public void cadastrar(Matricula matriculaDao) { this.em.persist(matriculaDao);}

    public List<Matricula> buscarTodos() {
        String jpql = "SELECT m FROM Matricula m";
        return em.createQuery(jpql, Matricula.class).getResultList();
    }

    public void removerMatricula(Matricula matricula) {
        em.merge(matricula);
        em.remove(matricula);
    }

    public static void alterarMatricula(Matricula matricula) {
        em.merge(matricula);
    }

    public Matricula buscarPorId(int id) {
        return em.find(Matricula.class, id);
    }
}
