package dao;

import model.Planos;

import javax.persistence.EntityManager;
import java.util.List;

public class PlanosDao {
    private EntityManager em;

    public PlanosDao(EntityManager em) {this.em = em;}

    public void cadastrar(Planos planosDao) { this.em.persist(planosDao);}

    public List<Planos> buscarTodos() {
        String jpql = "SELECT p FROM Planos p";
        return em.createQuery(jpql, Planos.class).getResultList();
    }

    public void remover(Planos planosDao) {
        em.merge(planosDao);
        em.remove(planosDao);
    }

    public void alterar(PlanosDao planosDao) {
        em.merge(planosDao);
    }

    public Planos buscarPorId(int id) {
        return em.find(Planos.class, id);
    }
}
