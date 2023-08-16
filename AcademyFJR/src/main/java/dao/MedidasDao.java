package dao;

import model.Matricula;
import model.Medidas;

import javax.persistence.EntityManager;
import java.util.List;

public class MedidasDao {
    private static EntityManager em;

    public MedidasDao(EntityManager em) {this.em = em;}

    public void cadastrar(Medidas medidasDao) { this.em.persist(medidasDao);}

    public List<Medidas> buscarTodos() {
        String jpql = "SELECT m FROM Medidas m";
        return em.createQuery(jpql, Medidas.class).getResultList();
    }
    public void removerMedidas(Medidas medidasDao) {
        em.merge(medidasDao);
        em.remove(medidasDao);
    }

    public static void alterarMedidas(Medidas medidasDao) {
        em.merge(medidasDao);
    }

    public Medidas buscarPorId(int id) {
        return em.find(Medidas.class, id);
    }
}
