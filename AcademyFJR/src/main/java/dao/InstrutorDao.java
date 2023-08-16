package dao;

import model.Instrutor;

import javax.persistence.EntityManager;
import java.util.List;

public class InstrutorDao {

    private EntityManager em;

    public InstrutorDao(EntityManager em) { this.em = em;}

    public void cadastrar(Instrutor instrutorDao) { this.em.persist(instrutorDao);}

    public List<Instrutor> buscarTodos() {
        String jpql = "SELECT i FROM Instrutor i";
        return em.createQuery(jpql, Instrutor.class).getResultList();
    }

    public void removerInstrutor(Instrutor instrutorDao) {
        em.merge(instrutorDao);
        em.remove(instrutorDao);
    }

    public void alterarInstrutor(Instrutor instrutorDao) {
        em.merge(instrutorDao);
    }

    public Instrutor buscarPorId(int id) {
        return em.find(Instrutor.class, id);
    }
}
