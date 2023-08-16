package model;

import javax.persistence.*;

@Entity
@Table (name = "formapagamento")

public class FormaPagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idFormaPagamento;
    public String descricao;

    public int getIdFormaPagamento() {
        return idFormaPagamento;
    }

    public void setIdFormaPagamento(int idFormaPagamento) {
        this.idFormaPagamento = idFormaPagamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }




}
