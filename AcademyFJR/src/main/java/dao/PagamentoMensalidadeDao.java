package dao;

import model.Matricula;
import model.PagamentoMensalidade;

import javax.persistence.EntityManager;
import java.util.List;

public class PagamentoMensalidadeDao {

    private EntityManager em;

    public PagamentoMensalidadeDao(EntityManager em) {this.em = em;}

    public void cadastrar(PagamentoMensalidade pagamentoMensalidade) { this.em.persist(pagamentoMensalidade);}

    public List<PagamentoMensalidade> buscarTodos() {
        String jpql = "SELECT p FROM PagamentoMensalidade p";
        return em.createQuery(jpql, PagamentoMensalidade.class).getResultList();
    }

    public void removerPagamentoMensalidade(PagamentoMensalidade pagamentoMensalidadeDao) {
        em.merge(pagamentoMensalidadeDao);
        em.remove(pagamentoMensalidadeDao);
    }

    public void alterar(PagamentoMensalidade planosDao) {
        em.merge(planosDao);
    }

    public PagamentoMensalidade buscarPorId(int id) {
        return em.find(PagamentoMensalidade.class, id);
    }
}
