package dao;

import model.FormaPagamento;
import javax.persistence.EntityManager;
import java.util.List;

public class FormaPagamentoDao {
    private EntityManager em;

    public FormaPagamentoDao(EntityManager em) { this.em = em; }
    public void cadastrar(FormaPagamento formaPagamento) {
        this.em.persist(formaPagamento);
    }

    public List<FormaPagamento> buscarTodos() {
        String jpql = "SELECT p FROM FormaPagamento p";
        return em.createQuery(jpql, FormaPagamento.class).getResultList();
    }
    public void removerFormaPagamento(FormaPagamento formaPagamento) {
        em.merge(formaPagamento);
        em.remove(formaPagamento);
    }

    public void alterarFormaPagamento(FormaPagamento formaPagamento) {
        em.merge(formaPagamento);
    }

    public FormaPagamento buscarPorId(int id) {
        return em.find(FormaPagamento.class, id);
    }
}
