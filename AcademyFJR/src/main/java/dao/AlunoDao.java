package dao;

import model.Aluno;

import javax.persistence.EntityManager;
import java.util.List;

public class AlunoDao {
    private EntityManager em;

    public AlunoDao(EntityManager em) {this.em = em;}

    public void cadastrar(Aluno alunoDao) { this.em.persist(alunoDao);}

    public List<Aluno> buscarTodos() {
        String jpql = "SELECT a FROM Aluno a";
        return em.createQuery(jpql, Aluno.class).getResultList();
    }

    public void removerAluno(Aluno alunoDao) {
        em.merge(alunoDao);
        em.remove(alunoDao);
    }

    public void alterar(Aluno medidasDao) {
        em.merge(medidasDao);
    }

    public Aluno buscarPorId(int id) {
        return em.find(Aluno.class, id);
    }

}
